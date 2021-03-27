package BookBasket.utils;

import BookBasket.service.AdminService;
import BookBasket.service.AdminServiceManager;
import BookBasket.service.BookService;
import BookBasket.service.BookServiceManager;
import BookBasket.service.OrderService;
import BookBasket.service.OrderServiceManager;
import BookBasket.service.UserService;
import BookBasket.service.UserServiceManager;

public class ServiceFactory {
	public static BookService getBookService() {
		return new BookServiceManager();
	}
	
	public static UserService getUserService() {
		return new UserServiceManager();
	}
	
	public static AdminService getAdminService() {
		return new AdminServiceManager();
	}
	
	public static OrderService getOrderService() {
		return new OrderServiceManager();
	}
}
