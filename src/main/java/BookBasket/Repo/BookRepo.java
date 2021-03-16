package BookBasket.Repo;

import java.util.List;

import BookBasket.model.Book;

public interface BookRepo {
	Book findById(int id);
	List<Book> allBooks();
	
	Boolean add(Book b);
	
	Boolean edit(int id);
	
	Boolean delete(int id);
	
	List<Book> findByAvailable();
	List<Book> findByPending();
	
}
