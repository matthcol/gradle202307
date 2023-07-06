package servlets;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GoodBye
 */
@WebServlet("/Goodbye")
public class GoodBye extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("title", "That's all folks");
		request.setAttribute("method", request.getMethod());
		request.setAttribute("place", "In L.A.");
		LocalDateTime dt = LocalDateTime.now(ZoneId.of("America/Los_Angeles"));
		request.setAttribute("clock", dt);
		request.getRequestDispatcher("/Display.jsp")
         		.forward(request, response);	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
