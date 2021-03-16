package BookBasket;

import static spark.Spark.port;

import BookBasket.controller.BookController;
import BookBasket.controller.UserController;

public class AppEntry {
	public static void main(String[] args) {
		port(8085);
		BookController.initBookController();
		UserController.initUserController();
	}
}
