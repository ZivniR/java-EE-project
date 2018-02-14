package modle;

import java.util.List;

public interface IToDoListDAO {

	/*
	 * add item to database
	 */
	void AddItem(Item item) throws ToDoListHibernateExceptions;
	
	/*
	 * delete item from database
	 */
	void DeleteItem(int item) throws ToDoListHibernateExceptions;
	
	/*
	 * add user to database
	 */
	void AddUser(User user) throws ToDoListHibernateExceptions;
	
	/*
	 * delete user from database
	 */
	void DeleteUser(int user) throws ToDoListHibernateExceptions;
	
	/*
	 * update item in the database
	 */
	void UpdateItem(Item item) throws ToDoListHibernateExceptions;
	
	/*
	 * validate user
	 */
	boolean ValidUser (String name, String password) throws ToDoListHibernateExceptions;

	/*
	 * return all items of one user
	 */
	List<Item> AllItems(int name)throws ToDoListHibernateExceptions;
	
	/*
	 * return user id
	 */
	int Userid(String name, String password) throws ToDoListHibernateExceptions;
	
	/*
	 * return user info from database
	 */
	User ThisUser(String name,String password)throws ToDoListHibernateExceptions;
	
}
