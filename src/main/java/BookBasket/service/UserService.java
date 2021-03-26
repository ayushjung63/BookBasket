package BookBasket.service;

import java.util.List;

import BookBasket.model.User;

public interface UserService {
	
	Boolean addUser(User user);
	
	Boolean checkUser(User user);
	
	List<User> viewAllUser();

}
