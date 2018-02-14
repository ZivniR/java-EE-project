package modle;

public class Item {
	int Serial;
	User User;
	String ItemName;
	String Description;
	
	Item() {}
	
	/*
	 * Contractor
	 */
	public Item(int serial,String itemname, String description,User user){
		setSerial(serial);
		setItemName(itemname);
		setDescription(description);
		setUser(user);
	}
	
	/*
	 * return description
	 */
	public String getDescription() {
		return Description;}
	
	/*
	 * set description
	 */
	public void setDescription(String str) {
		Description = str;
	}

	/*
	 * return ItemName
	 */
	public String getItemName() {
		return ItemName;}

	/*
	 * Set ItemName
	 */
	public void setItemName(String str) {
		ItemName = str;
	}
	
	/*
	 * return Serial
	 */
	public int getSerial() {
		return Serial;}

	/*
	 * Set Serial
	 */
	public void setSerial(int num) {
		Serial = num;
	}

	/*
	 * return User
	 */
	public User getUser() {
		return User;}

	/*
	 * set (change) User
	 */
	public void setUser(User owner) {
		User = owner;
	}	

	/*
	 * toString
	 */
	public String toString() {
		return "Serial:"+getSerial()+" Name:"+getItemName()+" Description:"+getDescription();
		
	}
}
