package modle;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.Session;

public class HibernateDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		HibernateToDoListDAO htd = HibernateToDoListDAO.getInstance();
		User user1 = new User(305564916, "ziv nir", 27, "0508939727");
		Item item1 = new Item(0,"workout","some boxing with gal",user1);
		Item item2 = new Item(1,"visit friend","go visit gal in the hospital",user1);
		Item item3 = new Item(2,"cock","cock gal a mill",user1);
		Item item4 = new Item(2,"cock","cock Ben a mill",user1);
		try {

			//htd.AddUser(user1);
			//htd.AddItem(item1);
			//htd.AddItem(item2);
			//htd.AddItem(item3);
			//htd.UpdateItem(item4);
			boolean flag = htd.ValidUser("ziv nir", "0508939727");
			if (flag == true)
				System.out.println("Achla");
			//htd.DeleteItem(1, user1);
			//htd.DeleteUser(305564916); // will throw an exception because he still have items
		} catch (ToDoListHibernateExceptions e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
