package BookBasket.service;

import java.util.List;


import BookBasket.model.Book;
import BookBasket.model.User;

public interface BookService {
	
	public boolean addBook(Book b);
	
	public List<Book> viewAllBooks();
	
	public Book viewById(int id);
	
	public Boolean editBook(int id,Book b);
	
	public Boolean deleteBook(int id);
	
	public List<Book> viewByType(String type, User user);
	
	public List<Book> viewByCategory(String  category,User user);

	public List<Book> viewByAuthor(String author);
	
	boolean bookBook(Book book);
	boolean approveBook(int id);
	
	List<Book> availableBooks(String ab);
	
	int countBooks();
	
	List<Book> userBooks(int id);
	
	List<Book> viewByKeyword(String key);
	
	List<Book> viewOtherBooks(int id);


}
