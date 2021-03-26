package BookBasket;

import static spark.Spark.port;

import BookBasket.controller.AdminController;
import BookBasket.controller.BookController;
import BookBasket.controller.UserController;
import BookBasket.utils.SessionFactory;

public class AppEntry {
	public static void main(String[] args) {
		port(8085);
		BookController.add();
		BookController.initBookController();
		UserController.initUserController();
		AdminController.initAdminController();
	}
}
