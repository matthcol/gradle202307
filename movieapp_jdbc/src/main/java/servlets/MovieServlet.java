package servlets;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.Movie;
import db.DbTools;

/**
 * Servlet implementation class Bonjour
 */
@WebServlet("/Movies")
public class MovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	@Override
	public void init(ServletConfig config) throws ServletException {
         super.init(config);
         DbTools.loadParams();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		var movies= DbTools.readMovies();
		request.setAttribute("movies", movies);
		request.getRequestDispatcher("/Movies.jsp")
				.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// read movie fields from form
		request.setCharacterEncoding("UTF-8");
		var title = request.getParameter("title");
		var yearStr = request.getParameter("year");
		var year = Short.parseShort(yearStr);
		// create new object Movie
		var movie = Movie.builder()
				.title(title)
				.year(year)
				.toMovie();
		// store new Movie in Database
		DbTools.addMovie(movie);
		// go back to the list of movies with GET method
		doGet(request, response);
	}

}
