package modle;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import modle.ToDoListHibernateExceptions;

public class HibernateToDoListDAO implements IToDoListDAO {
	private static HibernateToDoListDAO instance = null;
	
	private HibernateToDoListDAO(){	}
	
	public static HibernateToDoListDAO getInstance() {
	      if(instance == null) {
	    	  instance = new HibernateToDoListDAO(); 
	    	  }
	return instance;      
	}
	

	/*
	 * (non-Javadoc)
	 * @see modle.IToDoListDAO#AddItem(modle.Item)
	 */
	@Override
	public void AddItem(Item item) throws ToDoListHibernateExceptions {
		// TODO Auto-generated method stub
		SessionFactory factory = HibernateSessionFactory.getInstance();
		Session session = factory.openSession();
		session.beginTransaction();
		session.save(item);
		session.getTransaction().commit();
		session.close();
	
	}

	/*
	 * (non-Javadoc)
	 * @see modle.IToDoListDAO#DeleteItem(int)
	 */
	@Override
	public void DeleteItem(int item) throws ToDoListHibernateExceptions {
		// TODO Auto-generated method stub
		SessionFactory factory = HibernateSessionFactory.getInstance();
		Session session = factory.openSession();
		session.beginTransaction();
		Query query = session.createQuery("delete Item where Serial= :id");
		query.setParameter("id", item);
		int result = query.executeUpdate();
		session.getTransaction().commit();
		if(result>0)
		  System.out.println("error");
		

		}
		


	/*
	 * (non-Javadoc)
	 * @see modle.IToDoListDAO#AddUser(modle.User)
	 */
	@Override
	public void AddUser(User user) throws ToDoListHibernateExceptions {
		// TODO Auto-generated method stub
		SessionFactory factory = HibernateSessionFactory.getInstance();
		Session session = factory.openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		session.close();	

	}

	/*
	 * (non-Javadoc)
	 * @see modle.IToDoListDAO#DeleteUser(int)
	 */
	@Override
	public void DeleteUser(int user) throws ToDoListHibernateExceptions {
		// TODO Auto-generated method stub
		SessionFactory factory = HibernateSessionFactory.getInstance();
		Session session = factory.openSession();
		session.beginTransaction();
		Query query = session.createQuery("delete User where ID= :id");
		query.setParameter("id", user);
		int result = query.executeUpdate();
		session.getTransaction().commit();
		if(result<0)
		  System.out.println("error");		

	}

	/*
	 * (non-Javadoc)
	 * @see modle.IToDoListDAO#UpdateItem(modle.Item)
	 */
	@Override
	public void UpdateItem(Item item) throws ToDoListHibernateExceptions {
		// TODO Auto-generated method stub
		SessionFactory factory = HibernateSessionFactory.getInstance();
		Session session = factory.openSession();
		session.beginTransaction();
		Query query = session.createQuery("delete Item where Serial= :id");
		query.setParameter("id", item.getSerial());
		int result = query.executeUpdate();
		session.getTransaction().commit();
		
		Session session2 = factory.openSession();
		session2.beginTransaction();
		session2.save(item);
		session2.getTransaction().commit();
		session2.close();
	
	}
	
	/*
	 * (non-Javadoc)
	 * @see modle.IToDoListDAO#ValidUser(java.lang.String, java.lang.String)
	 */
	public boolean ValidUser (String name, String password) throws ToDoListHibernateExceptions{
		SessionFactory factory = HibernateSessionFactory.getInstance();
		Session session = factory.openSession();
		session.beginTransaction();
		Query query = session.createQuery("from User where Name= :id and Password= :password");
		query.setParameter("id", name);
		query.setParameter("password", password);
		List result = query.list();
		session.getTransaction().commit();
		if (result.isEmpty())
			return false;
		
		return true ;
	}

	/*
	 * (non-Javadoc)
	 * @see modle.IToDoListDAO#AllItems(int)
	 */
	public List<Item> AllItems(int name)throws ToDoListHibernateExceptions{
		SessionFactory factory = HibernateSessionFactory.getInstance();
		Session session = factory.openSession();
		session.beginTransaction();
		List <Item> result;
		String hql = "FROM Item WHERE User.ID=:id  ";
		Query query = session.createQuery(hql);
		query.setParameter("id", name);
		result =(List<Item>) query.list();
		List<Item> employees = (List<Item>) session.createCriteria(Item.class).list();
		session.getTransaction().commit();
		
		return result;
	}
	
	/*
	 * (non-Javadoc)
	 * @see modle.IToDoListDAO#Userid(java.lang.String, java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	public int Userid(String name, String password) throws ToDoListHibernateExceptions{
		SessionFactory factory = HibernateSessionFactory.getInstance();
		Session session = factory.openSession();
		session.beginTransaction();
		String hql = "SELECT ID FROM User WHERE Name=:name and Password=:password  ";
		Query query = session.createQuery(hql);
		query.setParameter("name", name);
		query.setParameter("password", password);
		List list;
		int id = 0;
		list =(List) query.list();
		id=(int)list.get(0);
		return id;
	}
	
	/*
	 * (non-Javadoc)
	 * @see modle.IToDoListDAO#ThisUser(java.lang.String, java.lang.String)
	 */
	public User ThisUser(String name,String password)throws ToDoListHibernateExceptions{
		SessionFactory factory = HibernateSessionFactory.getInstance();
		Session session = factory.openSession();
		session.beginTransaction();	
		String hql = "FROM User WHERE Name=:name and Password=:password  ";
		Query query = session.createQuery(hql);
		query.setParameter("name", name);
		query.setParameter("password", password);
		List<User> list;
		list = (List<User>) query.list();
		User user = list.get(0);
		return user;}
}
