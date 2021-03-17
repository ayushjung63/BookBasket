package BookBasket.controller;
import static spark.Spark.*;

import com.google.gson.Gson;

import BookBasket.model.Admin;
import BookBasket.utils.ServiceFactory;

public class AdminController {
	
	private static void addAdmin() {
		post("/api/admin/addAdmin",(req,res)->{
			Admin admin=new Gson().fromJson(req.body(),Admin.class);
			return ServiceFactory.getAdminService().addAdmin(admin);
		});
	}
	
	public static void initAdminController() {
		addAdmin();
	}
}
