package BookBasket.utils;

import BookBasket.service.UserService;
import BookBasket.service.UserServiceManager;

public class UserFactory {
	public static UserService getUserService() {
		return new UserServiceManager();
	}
}
