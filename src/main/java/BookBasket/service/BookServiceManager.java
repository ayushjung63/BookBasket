package BookBasket.service;

import java.util.List;

import BookBasket.Repo.BookRepo;
import BookBasket.Repo.UserRepo;
import BookBasket.model.Book;
import BookBasket.model.Book.Status;
import BookBasket.model.User;
import BookBasket.utils.RepoFactory;

public class BookServiceManager implements BookService {
	private BookRepo bookRepo;
	private UserRepo userRepo;
	
	public BookServiceManager() {
	this.bookRepo=RepoFactory.getBookRepo();
	this.userRepo=RepoFactory.getUserRepo();
	}
	
	@Override
	public boolean addBook(Book b) {
		b.setStatus(Status.ADMINPENDING);
		User user=userRepo.findUserById(b.getAddedBy().getId());
		if(user==null || user.equals("") ) return false;
		return bookRepo.add(b);
	}
	

	@Override
	public List<Book> viewByKeyword(String key) {
		return bookRepo.getByKeyword(key);
	}

	@Override
	public List<Book> viewAllBooks() {
		return bookRepo.allBooks();
	}

	@Override
	public Book viewById(int id) {
		return bookRepo.findById(id);
	}


	@Override
	public Boolean editBook(int id,Book b) {
		System.out.println("here1");
		return bookRepo.edit(id,b);
	}

	@Override
	public Boolean deleteBook(int id) {
		return bookRepo.delete(id);
	}

	@Override
	public List<Book> viewByType(String type,User user) {
		System.out.println(type+" Service "+user);
		return bookRepo.getByType(type,user);
	}

	@Override
	public List<Book> viewByCategory(String category,User user) {
		return bookRepo.getByCategory(category,user);
	}

	@Override
	public List<Book> viewByAuthor(String author) {
		return bookRepo.getByAuthor(author);
	}

	@Override
	public boolean bookBook(Book book) {
		return bookRepo.bookBook(book);
	}

	@Override
	public List<Book> availableBooks(String ab) {
		System.out.println("service ........");
		return bookRepo.availableBooks(ab);
	}

	@Override
	public int countBooks() {
		return bookRepo.getcountBooks();
	}

	@Override
	public List<Book> userBooks(int id) {
		return bookRepo.getUserBook(id);
	}

	@Override
	public boolean approveBook(int id) {
		return bookRepo.approveBook(id);
	}

	@Override
	public List<Book> viewOtherBooks(int id) {
		User user=userRepo.findUserById(id);
		return bookRepo.findOtherBooks(user);
	}


}
