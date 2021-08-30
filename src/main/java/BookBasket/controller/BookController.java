package BookBasket.controller;

import static spark.Spark.*;
import com.google.gson.Gson;
import com.google.gson.JsonParseException;

import BookBasket.model.Book;
import BookBasket.model.User;
import BookBasket.utils.ServiceFactory;

public class BookController {

	public static void add() {
		post("/api/book/add",(req,res)->{
			Book b=null;
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
			boolean result= ServiceFactory.getBookService().addBook(b);
			if(result==false) return "Something Wrong. Book not added.";
			else return "Book added Sucessfully";
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
		post("/api/book/type/:type",(req,res)->{
			String type=req.params("type");
			User user=new Gson().fromJson(req.body(), User.class);
			System.out.println(user);
			return new Gson().toJson(ServiceFactory.getBookService().viewByType(type,user));
		});
	}
	
	public static void bookCategory() {
		post("/api/book/category/:category",(req,res)->{
			String category=req.params("category");
			User user=new Gson().fromJson(req.body(),User.class);
			return new Gson().toJson(ServiceFactory.getBookService().viewByCategory(category,user));
		});
	}
	
	public static void availableBooks() {
		get("/available",(req,res)->{
			System.out.println("here");
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
	
	public static void otherBook() {
		post("/others",(req,res)->{
			User user=new Gson().fromJson(req.body(),User.class);
			System.out.println(req.body());
			return new Gson().toJson(ServiceFactory.getBookService().viewOtherBooks(user.getId()));
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
		otherBook();
	}
}
