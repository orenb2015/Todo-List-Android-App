package il.ac.hit.todolist.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * the actual implemntation of the hibernate todo list dao. all database related
 * methods goes here.
 * 
 */
public class HibernateToDoListDAO implements IToDoListDAO {

	private SessionFactory sessionFactory = null;

	/**
	 * creates a session factory if it has not been created yet. the session
	 * factory is single on this object.
	 */
	private SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			sessionFactory = new Configuration().configure()
					.buildSessionFactory();
		}
		return sessionFactory;
	}

	/**
	 * dispose of the object
	 */
	public void closeSessionFactory() {
		if (sessionFactory != null) {
			sessionFactory.close();
		}
	}

	/**
	 * creates a new hibernate session and transaction.
	 */
	public IDAOSession createNewSession() {
		Session session = getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		return new HibernateDAOSession(session, transaction);
	}

	/**
	 * add a new item to the specific session.
	 */
	public Item addItem(IDAOSession session, String title, String description,
			int userId) {
		Item item = new Item();
		item.setTitle(title);
		item.setDescription(description);
		item.setUserId(userId);

		((HibernateDAOSession) session).getSession().save(item);

		return item;
	}

	/**
	 * delete an item for a specific hibernate session
	 */
	public void deleteItem(IDAOSession session, int id) {
		Item item = new Item();
		item.setId(id);
		((HibernateDAOSession) session).getSession().delete(item);
	}

	/**
	 * gets all items from the database, for a specific session
	 */
	public List<Item> getItems(IDAOSession session) {
		return (List<Item>) ((HibernateDAOSession) session).getSession()
				.createQuery("from Item").list();
	}

	/**
	 * updates/edit a given item, for a specific session
	 */
	public void updateItem(IDAOSession session, Item item) {
		((HibernateDAOSession) session).getSession().update(item);
	}

	/**
	 * add a new user to the database, for a specific session
	 */
	public User addUser(IDAOSession session, String fullName, String userName,
			String password) {
		User user = new User();
		user.setFullName(fullName);
		user.setUserName(userName);
		user.setPassword(password);
		((HibernateDAOSession) session).getSession().save(user);
		return user;
	}

	/**
	 * authenticates the given user and password, for a specific session.
	 * 
	 * @return the user ID if present, or null if the user with the given
	 *         password was not found
	 */
	public int authenticateUser(IDAOSession session, String userName,
			String password) {
		User user = (User) ((HibernateDAOSession) session)
				.getSession()
				.createQuery(
						"from User where userName='" + userName
								+ "' and password='" + password + "'")
				.uniqueResult();
		if (user == null)
			return Integer.MIN_VALUE;
		else
			return user.getId();
	}

}
