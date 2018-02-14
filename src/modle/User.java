package modle;

public class User {
	String Name;
	int ID;
	int Age;
	String Password;
	
	User(){}
	/*
	 * Constructor 
	 */
	public User(int id,String name,int age,String password){
		setName(name);
		setID(id);
		setAge(age);
		setPassword(password);
	}
	
	/*
	 * Constructor 
	 */
	public User(String name,String password) {
		setName(name);
		setPassword(password);
		Age=0;
		ID=0;
	}

	/*
	 * return name
	 */
	public String getName() {
		return Name;}

	/*
	 * set name
	 */
	public void setName(String str) {
		Name = str;
	}

	/*
	 * return ID
	 */
	public int getID() {
		return ID;}
	
	/*
	 * set Id
	 */
	public void setID(int num) {
		ID = num;
	}
	
	/*
	 * return age
	 */
	public int getAge() {
		return Age;}
	
	/*
	 * set age
	 */
	public void setAge(int num) {
		Age = num;
	}
	

	/*
	 * return Password
	 */
	public String getPassword() {
		return Password;}

	/*
	 * set password
	 */
	public void setPassword(String str) {
		Password = str;
	}


}
