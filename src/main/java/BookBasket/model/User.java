package BookBasket.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.UniqueConstraint;

@NamedQueries({
		@NamedQuery(
				name = "findUserByUsername",
				query = "from User where username=:username"
		),
		@NamedQuery(
				name = "findUserByEmail",
				query = "from User where email=:email"
		)
}
	)
	

@Entity
public class User {
	
	@Id
	@GeneratedValue
	private int id;
	private String username;
	private String password;
	private String email;
	private String contact;
	private String address;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email
				+ ", contact=" + contact + ", address=" + address + "]";
	}
	

	
}
