package BookBasket.service;

import java.util.List;

import BookBasket.Repo.BookRepo;
import BookBasket.model.Book;
import BookBasket.utils.RepoFactory;

public class BookServiceManager implements BookService {
	private BookRepo bookRepo;
	
	public BookServiceManager() {
	this.bookRepo=RepoFactory.getBookRepo();
	}
	
	@Override
	public boolean addBook(Book b) {
		bookRepo.add(b);
		return true;
	}

	@Override
	public List<Book> viewAllBooks() {
		return bookRepo.allBooks();
	}

	@Override
	public void viewByType(String type) {
		
	}

	@Override
	public Book viewById(int id) {
		return bookRepo.findById(id);
	}

	@Override
	public List<Book> viewByAvailable() {
		return bookRepo.findByAvailable();
	}

	@Override
	public List<Book> viewByPending() {
		return bookRepo.findByPending();
	}

	@Override
	public Boolean editBook(int id) {
		return bookRepo.edit(id);
	}

	@Override
	public Boolean deleteBook(int id) {
		bookRepo.delete(id);
		return null;
	}

}
