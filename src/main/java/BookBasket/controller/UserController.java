package BookBasket.controller;

import static spark.Spark.get;
import static spark.Spark.post;

import com.google.gson.Gson;

import BookBasket.model.Book;
import BookBasket.model.User;
import BookBasket.utils.ServiceFactory;
import spark.Spark.*;

public class UserController {
	
	public static void login() {
		post("api/user/login",(req,res)->{
			 res.type("application/json");
			User user=new Gson().fromJson(req.body(), User.class);
			return new Gson().toJson(ServiceFactory.getUserService().login(user));
		});
		}
	
	public static void addUser() {
		post("api/user/adduser", (req, res) -> {
			User user = new Gson().fromJson(req.body(), User.class);
			System.out.println(user);
			return ServiceFactory.getUserService().addUser(user);
		});
	}
	
	public static void allUser() {
		get("/api/user/alluser", (req, res) -> {
			return new Gson().toJson(ServiceFactory.getUserService().viewAllUser());
		});
	}
		
	
	public static void initUserController() {
		login();
		addUser();
		allUser();
	}
}
