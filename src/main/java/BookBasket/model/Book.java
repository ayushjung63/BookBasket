package BookBasket.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="book")
public class Book {
	@Id
	@GeneratedValue
	private int id;
	private String title;
	private String author;
	private int price;
	private String category;
	private String description;
	private String type;
	private String image;
	private String Accepted="false";
	private String Available="true";
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getAccepted() {
		return Accepted;
	}
	public void setAccepted(String accepted) {
		Accepted = accepted;
	}
	public String getAvailable() {
		return Available;
	}
	public void setAvailable(String available) {
		Available = available;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", price=" + price + ", category="
				+ category + ", description=" + description + ", type=" + type + ", image=" + image + ", Accepted="
				+ Accepted + ", Available=" + Available + "]";
	}
	
}
