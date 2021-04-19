package BookBasket.controller;

import static spark.Spark.*;
import com.google.gson.Gson;
import com.google.gson.JsonParseException;

import BookBasket.model.Book;
import BookBasket.utils.ServiceFactory;

public class BookController {

	public static void add() {
		post("/api/book/add",(req,res)->{
			Book b=null;
			//String img=ImageController.uploadImage();
			try {
				b=new Gson().fromJson(req.body(), Book.class);
			}catch(JsonParseException e) {
				e.printStackTrace();
				res.status(404);
				return false;
			}
			if(b.getTitle()==null && b.getTitle()=="") {
				return new BookBasket.model.Error(400,"Title cannot be null");
			}
			return ServiceFactory.getBookService().addBook(b);
		});
	}

	public static void viewAllBooks() {
		get("/api/book/allbooks", (req, res) -> {
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
		put("/api/book/edit/:id", (req, res) -> {
			Book book = new Gson().fromJson(req.body(), Book.class);
			System.out.println(book);
			int id = Integer.parseInt(req.params("id"));
			System.out.println(id);
			return ServiceFactory.getBookService().editBook(id,book);
		});
	}

	public static void deleteBook() {
		delete("/api/book/delete/:id", (req, res) -> { 
		  int id=Integer.parseInt(req.params("id"));
		  System.out.println(id);
		  return ServiceFactory.getBookService().deleteBook(id); 
		});
	}
	
	public static void bookType() {
		get("/api/book/type/:type",(req,res)->{
			String type=req.params("type");
			return new Gson().toJson(ServiceFactory.getBookService().viewByType(type));
		});
	}
	
	public static void bookCategory() {
		get("/api/book/category/:category",(req,res)->{
			String category=req.params("category");
			return new Gson().toJson(ServiceFactory.getBookService().viewByCategory(category));
		});
	}
	
	public static void availableBooks() {
		get("/available",(req,res)->{
			return new Gson().toJson( ServiceFactory.getBookService().availableBooks("AVAILABLE"));
			});
	}
	
	public static void bookAuthor() {
		get("/api/book/author/:author",(req,res)->{
			String author=req.params("author");
			return new Gson().toJson(ServiceFactory.getBookService().viewByAuthor(author));
		});
	}
	
	public static void countBooks() {
		get("/count",(req,res)->{return ServiceFactory.getBookService().countBooks();});
		}
	
	public static void userBooks() {
		get("/api/book/user/:id",(req,res)->{
			int id=Integer.parseInt(req.params("id"));
			return new Gson().toJson(ServiceFactory.getBookService().userBooks(id));
		});
	}
	
	public static void approveBook() {
		get("/api/book/approve/:id", (req, res) -> {
			int id = Integer.parseInt(req.params("id"));
			System.out.println(id);
			return ServiceFactory.getBookService().approveBook(id);
		});
	}
	
	public static void searchBook() {
		get("/api/book/search/:key",(req,res)->{
			String key=req.params("key");
			return new Gson().toJson(ServiceFactory.getBookService().viewByKeyword(key));
		});
	}
	

	
	
	
	public static void initBookController() {
		viewAllBooks();
		add();
		editBook();
		viewById();
		deleteBook();
		bookType();
		bookCategory();
		bookAuthor();
		availableBooks();
		userBooks();
		approveBook();
		countBooks();
		searchBook();
	}
}
