package il.ac.hit.todolist.controllers;

import il.ac.hit.todolist.model.Item;
import il.ac.hit.todolist.model.ToDoListService;

import javax.servlet.http.HttpSession;


/**
 * Utilities class for various functions needed
 * 
 */
public class Utilities {
	/**
	 * check if the user is logged in.
	 * 
	 * @param session
	 *            http session to check the variables in
	 * @return true if logged in, false if not.
	 */
	public static boolean checkLogin(HttpSession session) {
		Object loggedIn = session.getAttribute("loggedIn");
		if (loggedIn == null || !(boolean) loggedIn) {
			return false;
		}

		return true;
	}

	/**
	 * gets a list of items, and returns only the item with specific given
	 * itemId
	 * 
	 * @param itemId
	 *            the itemId to filter by.
	 * @return the Item found in the database. null if not found.
	 */
	public static Item getItemById(int itemId) {
		ToDoListService todoListService = new ToDoListService();
		for (Item item : todoListService.getItems()) {
			if (item.getId() == itemId) {
				return item;
			}
		}
		return null;
	}
}
