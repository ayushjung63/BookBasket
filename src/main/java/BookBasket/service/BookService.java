package BookBasket.service;

import java.util.List;

import BookBasket.model.Book;

public interface BookService {
	
	public boolean addBook(Book b);
	
	public List<Book> viewAllBooks();
	
	public Book viewById(int id);
	
	public Boolean editBook(int id);
	
	public Boolean deleteBook(int id);
	
	public void viewByType(String Type);
	
	public List<Book> viewByPending();
	
	public List<Book> viewByAvailable();
	
}
