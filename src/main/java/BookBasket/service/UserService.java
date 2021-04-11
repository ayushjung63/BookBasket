package BookBasket.service;

import java.util.List;

import BookBasket.model.User;
import BookBasket.model.UserDTO;

public interface UserService {
	
	Boolean addUser(User user);
	
	UserDTO login(User user);
	
	List<User> viewAllUser();
	
	int count();

}
