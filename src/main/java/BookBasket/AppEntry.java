package BookBasket;

import static spark.Spark.*;

import BookBasket.controller.AdminController;
import BookBasket.controller.BookController;
import BookBasket.controller.OrderController;
import BookBasket.controller.UserController;
import BookBasket.utils.SessionFactory;

public class AppEntry {
	public static void main(String[] args) {
		port(8085);
		/*
		 * options("/*", (request, response) -> { String accessControlRequestHeaders =
		 * request.headers("Access-Control-Request-Headers"); if
		 * (accessControlRequestHeaders != null) {
		 * response.header("Access-Control-Allow-Headers", accessControlRequestHeaders);
		 * } String accessControlRequestMethod =
		 * request.headers("Access-Control-Request-Method"); if
		 * (accessControlRequestMethod != null) {
		 * response.header("Access-Control-Allow-Methods", accessControlRequestMethod);
		 * } return "OK"; }); before((request, response) -> {
		 * response.header("Access-Control-Allow-Origin", "*");
		 * response.header("Access-Control-Request-Method", "*");
		 * response.header("Access-Control-Allow-Headers", "*"); // Note: this may or
		 * may not be necessary in your particular application
		 * response.type("application/json"); });
		 */
		
		options("/*",
		        (request, response) -> {

		            String accessControlRequestHeaders = request
		                    .headers("Access-Control-Request-Headers");
		            if (accessControlRequestHeaders != null) {
		                response.header("Access-Control-Allow-Headers",
		                        accessControlRequestHeaders);
		            }

		            String accessControlRequestMethod = request
		                    .headers("Access-Control-Request-Method");
		            if (accessControlRequestMethod != null) {
		                response.header("Access-Control-Allow-Methods",
		                        accessControlRequestMethod);
		            }

		            return "OK";
		        });

		before((request, response) -> response.header("Access-Control-Allow-Origin", "*"));
		
		
		SessionFactory.getInstance();
		BookController.initBookController();
		UserController.initUserController();
		AdminController.initAdminController();
		OrderController.initOrderController();
	}
}
