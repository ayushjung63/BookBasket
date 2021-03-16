package BookBasket.Repo;

import java.util.List;

import BookBasket.model.User;

public interface UserRepo {
	User findUser(String username);
	
	Boolean add(User user);
	
	List<User> findAllUser();
}
