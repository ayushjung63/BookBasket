package BookBasket.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

@NamedQueries({
		@NamedQuery(
				name="findBytype",
				query="from Book where type=:type"
				),
		@NamedQuery(
				name="findByCategory",
				query="from Book where category=:category"
				),
		@NamedQuery(
				name="findByStatus",
				query="from Book where status=:status"
				),
		@NamedQuery(
				name="findByAuthor",
				query="from Book where author=:author"
				),
		@NamedQuery(
				name="availableBooks",
				query="from Book where status=:status"
				)
})

@Entity
public class Book {
	@Id
	@GeneratedValue
	private int id;
	private String title;
	private String author;
	private double price;
	private String category;
	private String description;
	private String type;
	private String image;
	private Status status;
	@OneToOne
	private User addedBy;
	
	public enum Status{
		AVAILABLE,
		ADMINPENDING,
		BOOKED
	}
	
	

	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
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

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public User getAddedBy() {
		return addedBy;
	}

	public void setAddedBy(User addedBy) {
		this.addedBy = addedBy;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", price=" + price + ", category="
				+ category + ", description=" + description + ", type=" + type + ", image=" + image + ", status="
				+ status + ", addedBy=" + addedBy + "]";
	}
	
	
	
}
