package BookBasket.utils;

import BookBasket.service.BookService;
import BookBasket.service.BookServiceManager;
import BookBasket.service.UserService;
import BookBasket.service.UserServiceManager;

public class ServiceFactory {
	public static BookService getBookService() {
		return new BookServiceManager();
	}
	
	public static UserService getUserService() {
		return new UserServiceManager();
	}
	
}
