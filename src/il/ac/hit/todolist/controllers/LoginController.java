package il.ac.hit.todolist.controllers;

import il.ac.hit.todolist.model.ToDoListService;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * responsible for logging the user into the todo list application
 * 
 */
public class LoginController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 407056058428113610L;

	/**
	 * checks the user and password that the user gave, and authenticate it
	 * against the database. if the user is valid, puts session variables, sets
	 * username cookie, and redirects to todo-list-controller.
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		HttpSession session = req.getSession();

		String enteredUsername = req.getParameter("username");
		String enteredPassword = req.getParameter("password");
		ToDoListService todoListService = new ToDoListService();
		int userId = todoListService.authenticateUser(enteredUsername,
				enteredPassword);
		if (userId != Integer.MIN_VALUE) {
			session.setAttribute("loggedIn", true);
			session.setAttribute("username", enteredUsername);
			session.setAttribute("userid", userId);

			resp.addCookie(new Cookie("username", enteredUsername));

			resp.sendRedirect("TodoListController");
		} else {
			session.setAttribute("loggedIn", false);
			session.removeAttribute("username");
			session.removeAttribute("userid");

			resp.sendRedirect("BadLogin.jsp");
		}
	}

}
