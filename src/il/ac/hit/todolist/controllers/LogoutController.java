package il.ac.hit.todolist.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * responsible for logging out the users out of the application.
 * 
 */
public class LogoutController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8870954400720494510L;

	/**
	 * this method logs the user out of the application. unset the variables,
	 * and redirect to Login.jsp for re-login
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		HttpSession session = req.getSession();
		session.setAttribute("loggedIn", false);
		session.removeAttribute("username");
		session.removeAttribute("userid");

		resp.sendRedirect("Login.jsp");
	}

}
