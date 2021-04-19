package BookBasket.controller;
import static spark.Spark.*;

import com.google.gson.Gson;

import BookBasket.model.Admin;
import BookBasket.utils.ServiceFactory;

public class AdminController {
	
	
	
	private static void loginAdmin() {
		post("/api/admin/login",(req,res)->{
			Admin admin=new Gson().fromJson(req.body(),Admin.class);
			if(admin.getUser().equals(Admin.username)&&admin.getPw().equals(Admin.password) ) {
				return true;
			}else {
				return false;
			}
		});
	}
	
	public static void initAdminController() {
		loginAdmin();
	}
}
