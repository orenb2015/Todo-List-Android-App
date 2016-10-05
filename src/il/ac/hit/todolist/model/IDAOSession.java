package il.ac.hit.todolist.model;

/**
 * Dao session interface
 */
public interface IDAOSession {
	/**
	 * closes the current session and transaction.
	 * 
	 * @param commit
	 *            if commit is true, commits the transaction before closing it.
	 *            if false, rolls it back.
	 */
	void close(boolean commit);
}
