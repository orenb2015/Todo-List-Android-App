package il.ac.hit.todolist.controllers;

import il.ac.hit.todolist.model.ToDoListService;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * This is the delete controller
 *
 */
public class DeleteController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4792152360773187953L;

	/**
	 * this will check the login, gets the id of what to delete, and delete it.
	 * after it, we will redirect to the todolist-controller to show the results
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		if (!Utilities.checkLogin(req.getSession())) {
			resp.sendRedirect("Login.jsp");
			return;
		}

		String id = req.getParameter("id");
		if (id == null || id.equals("")) {
			throw new ServletException("no ID");
		}
		int intID = Integer.parseInt(id);

		ToDoListService todoListService = new ToDoListService();
		todoListService.deleteItem(intID);

		resp.sendRedirect("TodoListController");
	}

}
