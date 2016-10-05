package il.ac.hit.todolist.controllers;

import il.ac.hit.todolist.model.Item;
import il.ac.hit.todolist.model.ToDoListService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * this controller is responsible for showing the todo list
 * 
 */
public class TodoListController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -185789412516242150L;

	/**
	 * this method check that the user is logged in, gets only the items that
	 * are relevant to the current user that is logged in, and then puts the
	 * items in the attribute "items" for showing in the TodoList.jsp
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		if (!Utilities.checkLogin(req.getSession())) {
			resp.sendRedirect("Login.jsp");
			return;
		}

		ToDoListService todoListService = new ToDoListService();
		List<Item> items = todoListService.getItems();

		int userId = (int) req.getSession().getAttribute("userid");
		List<Item> userItems = new ArrayList<>();
		for (Item item : items) {
			if (item.getUserId() == userId) {
				userItems.add(item);
			}
		}
		req.setAttribute("items", userItems);

		req.getRequestDispatcher("TodoList.jsp").forward(req, resp);
	}

}
