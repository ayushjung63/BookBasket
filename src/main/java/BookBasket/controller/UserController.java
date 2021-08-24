package BookBasket.controller;

import static spark.Spark.get;
import static spark.Spark.post;
import static spark.Spark.delete;

import BookBasket.model.Error;
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
			System.out.println(new Gson().toJson(ServiceFactory.getUserService().login(user)));
			return new Gson().toJson(ServiceFactory.getUserService().login(user));
		});
		}
	
	public static void addUser() {
		post("api/user/adduser", (req, res) -> {
			User user = new Gson().fromJson(req.body(), User.class);
			System.out.println(user);
			Boolean checkEmail=ServiceFactory.getUserService().checkUserByEmail(user.getEmail());
			System.out.println(checkEmail);
			//Boolean checkUsername = ServiceFactory.getUserService().checkUserByUsername(user.getUsername());
			if(checkEmail==true){
				return new Gson().toJson(
						new Error(409,"User with this email already exits. Please try again with different email"));
			}
//			else if(checkUsername==true) {
//					return new Gson().toJson(new Error(409, "Username taken. Try using other username"));
//			}

				System.out.println("Register " + user);
				return ServiceFactory.getUserService().addUser(user);

			});
	}
	
	public static void allUser() {
		get("/api/user/alluser", (req, res) -> {
			return new Gson().toJson(ServiceFactory.getUserService().viewAllUser());
		});
	}
	
	public static void countUser() {
		get("/user/count",(req,res)->{return ServiceFactory.getUserService().count();});
	}
	
	public static void deleteUser() {
		delete("/api/user/delete/:id", (req, res) -> { 
		  int id=Integer.parseInt(req.params("id"));
		  System.out.println(id);
		  System.out.println(ServiceFactory.getUserService().deleteUser(id));
		  return ServiceFactory.getUserService().deleteUser(id); 
		});
	}
		
	
	public static void initUserController() {
		login();
		addUser();
		allUser();
		countUser();
		deleteUser();
	}
}
