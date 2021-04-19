package BookBasket.model;

import javax.persistence.Entity;
import javax.persistence.Id;


public class Admin {
	public static final String username="admin";
	public static final String password="1234";
	
	private String user;
	private String pw;
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	@Override
	public String toString() {
		return "Admin [user=" + user + ", pw=" + pw + "]";
	}
	
	
}
