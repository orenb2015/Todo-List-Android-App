package il.ac.hit.todolist.controllers;

import il.ac.hit.todolist.model.Item;
import il.ac.hit.todolist.model.ToDoListService;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Edit controller servlet. contains get and post.
 * 
 */
public class EditController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5964167681097191972L;

	/**
	 * this edits the item. assumes the user provided all the necessary details
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		if (!Utilities.checkLogin(req.getSession())) {
			resp.sendRedirect("Login.jsp");
			return;
		}

		String itemId = req.getParameter("itemId");
		String title = req.getParameter("title");
		String description = req.getParameter("description");

		ToDoListService todoListService = new ToDoListService();
		Item item = Utilities.getItemById(Integer.valueOf(itemId));
		item.setTitle(title);
		item.setDescription(description);
		todoListService.updateItem(item);

		resp.sendRedirect("TodoListController");
	}

	/**
	 * gets the required information of the item, and displays it on the page. shows the page EditItem.jsp
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
		int itemID = Integer.parseInt(id);

		ToDoListService todoListService = new ToDoListService();
		for (Item item : todoListService.getItems()) {
			if (item.getId() == itemID) {
				req.setAttribute("id", item.getId());
				req.setAttribute("title", item.getTitle());
				req.setAttribute("description", item.getDescription());

				req.getRequestDispatcher("EditItem.jsp").forward(req, resp);
				return;
			}
		}
	}
}
