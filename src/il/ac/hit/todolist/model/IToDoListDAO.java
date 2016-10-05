package il.ac.hit.todolist.model;

import java.util.List;

public interface IToDoListDAO {
	/**
	 * dispose of the object
	 */
	void closeSessionFactory();

	/**
	 * creates a new hibernate session and transaction.
	 */
	IDAOSession createNewSession();

	/**
	 * add a new item to the specific session.
	 */
	Item addItem(IDAOSession session, String title, String description,
			int userId);

	/**
	 * delete an item for a specific hibernate session
	 */
	void deleteItem(IDAOSession session, int id);

	/**
	 * gets all items from the database, for a specific session
	 */
	List<Item> getItems(IDAOSession session);

	/**
	 * updates/edit a given item, for a specific session
	 */
	void updateItem(IDAOSession session, Item item);

	/**
	 * add a new user to the database, for a specific session
	 */
	User addUser(IDAOSession session, String fullName, String userName,
			String password);

	/**
	 * authenticates the given user and password, for a specific session.
	 * 
	 * @return the user ID if present, or null if the user with the given
	 *         password was not found
	 */
	int authenticateUser(IDAOSession session, String userName, String password);
}
