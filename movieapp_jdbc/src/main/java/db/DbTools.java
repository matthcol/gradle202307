package db;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.mariadb.jdbc.MariaDbDataSource;
import org.postgresql.ds.PGSimpleDataSource;

import data.Movie;

import java.io.IOException;

/**
 * Old school class to connect to db and fetch data only with JDBC
 * without ORM
 */
public class DbTools {
	
	private static String url = null;
	private static String user = null;
	private static String password = null;
	private static String provider = null;
	private static DataSource datasource = null;
	private static String jndiDataSourceName = null;
	
	private final static String SQL_ALL_MOVIES = "select * from movies " +
			" order by year desc, title";
	private final static String SQL_ADD_MOVIE = "insert into movies (title,year) values (?,?)";
	
	public static void loadParams() {
		try {
			var properties = new Properties();
			properties.load(
					DbTools.class
						.getClassLoader()
						.getResourceAsStream("database.properties")); 
			url = properties.getProperty("datasource.url");
			user = properties.getProperty("datasource.user");
			password = properties.getProperty("datasource.password");
			provider = properties.getProperty("datasource.provider");
			jndiDataSourceName = properties.getProperty("datasource.jndi");
			if (provider.equals("mariadb")){
				try {
					datasource = new MariaDbDataSource(url);
				} catch (SQLException e) {
					throw new RuntimeException(e);
				}
			} else if (provider.equals("postgresql")) {
				PGSimpleDataSource ds = new PGSimpleDataSource();
				ds.setUrl(url);
				datasource = ds;
			} else if (provider.equals("jndi")) {
				try {
					InitialContext ctx = new InitialContext();
					datasource = (DataSource)ctx.lookup(jndiDataSourceName);
				} catch (NamingException e) {
					throw new RuntimeException(e);
				}
			} else {
				throw new IllegalArgumentException("JDBC provider unknown");
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static Connection getConnection() throws SQLException {
		if (provider.equals("jndi")) {
			return datasource.getConnection();
		} else {
			return datasource.getConnection(user, password);
		}
	}
	
	public static List<Movie> readMovies() {
		try (var connection = getConnection()) {
			var movies = new ArrayList<Movie>();
			var st = connection.createStatement();
			var res = st.executeQuery(SQL_ALL_MOVIES);
			while (res.next()) {
				var movie = new Movie();
				movie.setId(res.getInt("id"));
				movie.setTitle(res.getString("title"));
				movie.setYear(res.getShort("year"));
				movies.add(movie);
			}
			return movies;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static void addMovie(Movie movie) {
		try (var connection = getConnection()) {
			var st = connection.prepareStatement(SQL_ADD_MOVIE);
			st.setString(1, movie.getTitle());
			st.setInt(2, movie.getYear());
			st.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
