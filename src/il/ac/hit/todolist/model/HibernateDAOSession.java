package il.ac.hit.todolist.model;

import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * hibernate specific DAO session
 * 
 */
public class HibernateDAOSession implements IDAOSession {
	/**
	 * gets the underlying hibernate session
	 */
	public Session getSession() {
		return session;
	}

	/**
	 * gets the underlying hibernate transaction
	 */
	public Transaction getTransaction() {
		return transaction;
	}

	/**
	 * simple constructor
	 */
	public HibernateDAOSession(Session session, Transaction transaction) {
		this.session = session;
		this.transaction = transaction;
	}

	private Session session = null;
	private Transaction transaction = null;

	/**
	 * closes the current session and transaction.
	 * 
	 * @param commit
	 *            if commit is true, commits the transaction before closing it.
	 *            if false, rolls it back.
	 */
	public void close(boolean commit) {
		if (session != null) {
			if (commit) {
				transaction.commit();
			} else {
				transaction.rollback();
			}

			session.close();
			session = null;
		}
	}

}
