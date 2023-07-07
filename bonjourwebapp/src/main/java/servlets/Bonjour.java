package servlets;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Bonjour
 * Say hello and give the local time whereas your are in London, Paris or 東京
 */
@WebServlet("/Bonjour")
public class Bonjour extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("title", "Hello Everyone");
		request.setAttribute("place", "There [ cœur, AŸ-CHAMPAGNE, 東京 ]");

		request.setAttribute("method", request.getMethod());
		LocalDateTime dt = LocalDateTime.now();
		request.setAttribute("clock", dt);
		request.getRequestDispatcher("/Display.jsp")
         		.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
