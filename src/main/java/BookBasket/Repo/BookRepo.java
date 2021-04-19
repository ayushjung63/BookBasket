package BookBasket.Repo;

import java.util.List;

import BookBasket.model.Book;

public interface BookRepo {
	Book findById(int id);
	List<Book> allBooks();
	Boolean add(Book b);
	Boolean edit(int id,Book b);
	Boolean delete(int id);
	List<Book> getByType(String type);
	List<Book> getByCategory(String category);
	List<Book> getByAuthor(String author);
	Boolean approveBook(int id);
	Boolean bookBook(Book book);
	List<Book> availableBooks(String ab);
	int getcountBooks();
	
	List<Book> getUserBook(int id);
	
	List<Book> getByKeyword(String keyword);
}
