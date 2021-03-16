package BookBasket.controller;

import static spark.Spark.*;

import com.google.gson.Gson;

import BookBasket.Repo.BookRepoManager;
import BookBasket.model.Book;
import BookBasket.utils.ServiceFactory;
import spark.Route;

public class BookController {

	public static void addBook() {
		post("api/addbook", (req, res) -> {
			Book book = new Gson().fromJson(req.body(), Book.class);
			return ServiceFactory.getBookService().addBook(book);
		});
	}

	public static void viewAllBooks() {
		get("/api/allbooks", (req, res) -> {
			return new Gson().toJson(ServiceFactory.getBookService().viewAllBooks());
		});
	}

	public static void viewById() {
		get("/api/book/:id", (req, res) -> {
			int id = Integer.parseInt(req.params(":id"));
			System.out.println(id);
			return new Gson().toJson(ServiceFactory.getBookService().viewById(id));
		});
	}

	public static void editBook() {
		post("/api/book/edit/:id", (req, res) -> {
			int id = Integer.parseInt(req.params("id"));
			return ServiceFactory.getBookService().editBook(id);
		});
	}

	public static void deleteBook() {
		  delete("/api/book/delete/:id", (req, res) -> { int
		  id=Integer.parseInt(req.params("id"));
		  return ServiceFactory.getBookService().deleteBook(id); 
		  });
	}


	public static void viewByPending() {
		get("/api/book/pending", (req, res) -> {
			return new Gson().toJson(ServiceFactory.getBookService().viewByPending());
		});
	}

	public static void viewByAvailable() {
		get("/api/book/available", (req, res) -> {
			return new Gson().toJson(ServiceFactory.getBookService().viewByAvailable());
		});
	}

	public static void initBookController() {
		viewAllBooks();
		addBook();
		viewById();
		viewByPending();
		viewByAvailable();
	}
}
