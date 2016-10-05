package il.ac.hit.todolist.model;

import java.util.List;

/**
 * this services keeps a singleton IToDoListDAO. this serves all database needs.
 * 
 */
public class ToDoListService {
	private static IToDoListDAO daoSingleton;

	/**
	 * creates the daoSingleton instance
	 */
	public ToDoListService() {
		if (daoSingleton == null)
			daoSingleton = new HibernateToDoListDAO();
	}

	/**
	 * this closes the session factory, and disposes of the singleton
	 */
	public void CloseDAO() {
		if (daoSingleton != null) {
			daoSingleton.closeSessionFactory();
			daoSingleton = null;
		}
	}

	/**
	 * creates a new dao session, adds the item, closes the session
	 */
	public Item addItem(String title, String description, int userId) {
		IDAOSession session = null;
		try {
			session = daoSingleton.createNewSession();
			Item newItem = daoSingleton.addItem(session, title, description,
					userId);
			session.close(true);
			return newItem;
		} catch (Exception ex) {
			if (session != null)
				session.close(false);
		}

		return null;
	}

	/**
	 * creates a new dao session, deletes the item, closes the session
	 */
	public void deleteItem(int id) {
		IDAOSession session = null;
		try {
			session = daoSingleton.createNewSession();
			daoSingleton.deleteItem(session, id);
			session.close(true);
		} catch (Exception ex) {
			if (session != null)
				session.close(false);
		}
	}

	/**
	 * creates a new dao session, returns all the items in the database, closes
	 * the session
	 */
	public List<Item> getItems() {
		IDAOSession session = null;
		try {
			session = daoSingleton.createNewSession();
			List<Item> items = daoSingleton.getItems(session);
			session.close(true);
			return items;
		} catch (Exception ex) {
			if (session != null)
				session.close(false);
		}
		return null;
	}

	/**
	 * creates a new dao session, update the given item, closes the session
	 */
	public void updateItem(Item item) {
		IDAOSession session = null;
		try {
			session = daoSingleton.createNewSession();
			daoSingleton.updateItem(session, item);
			session.close(true);
		} catch (Exception ex) {
			if (session != null)
				session.close(false);
		}
	}

	/**
	 * creates a new dao session, add the given user, closes the session
	 */
	public User addUser(String fullName, String userName, String password) {
		IDAOSession session = null;
		try {
			session = daoSingleton.createNewSession();
			User newUser = daoSingleton.addUser(session, fullName, userName,
					password);
			session.close(true);
			return newUser;
		} catch (Exception ex) {
			if (session != null)
				session.close(false);
		}

		return null;
	}

	/**
	 * creates a new dao session, authenticates the user, closes the session
	 * 
	 * @return Integer.MIN_VALUE if user could not be authenticated. otherwise,
	 *         the UserID.
	 */
	public int authenticateUser(String userName, String password) {
		IDAOSession session = null;
		try {
			session = daoSingleton.createNewSession();
			int userId = daoSingleton.authenticateUser(session, userName,
					password);
			session.close(true);
			return userId;
		} catch (Exception ex) {
			if (session != null)
				session.close(false);
		}

		return Integer.MIN_VALUE;
	}
}
