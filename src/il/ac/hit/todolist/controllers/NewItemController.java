package il.ac.hit.todolist.controllers;

import il.ac.hit.todolist.model.ToDoListService;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * this controller is reponsible for adding new items to the database
 * 
 */
public class NewItemController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6630205424511691912L;

	/**
	 * after providing details for the new item, this method adds the item to
	 * the database, and then redirects to the todo-list-controller to see the
	 * result
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		if (!Utilities.checkLogin(req.getSession())) {
			resp.sendRedirect("Login.jsp");
			return;
		}

		String title = req.getParameter("title");
		String description = req.getParameter("description");
		int userId = (int) req.getSession().getAttribute("userid");

		ToDoListService todoListService = new ToDoListService();
		todoListService.addItem(title, description, userId);

		resp.sendRedirect("TodoListController");
	}

}
