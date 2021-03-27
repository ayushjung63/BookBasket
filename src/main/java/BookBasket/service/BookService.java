package BookBasket.service;

import java.util.List;

import org.hibernate.annotations.Where;

import BookBasket.model.Book;

public interface BookService {
	
	public boolean addBook(Book b);
	
	public List<Book> viewAllBooks();
	
	public Book viewById(int id);
	
	public Boolean editBook(int id,Book b);
	
	public Boolean deleteBook(int id);
	
	public List<Book> viewByType(String type);
	
	public List<Book> viewByCategory(String  category);

	public List<Book> viewByAuthor(String author);
}
