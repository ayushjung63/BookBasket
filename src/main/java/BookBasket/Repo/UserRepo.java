package BookBasket.Repo;

import java.util.List;

import BookBasket.model.User;

public interface UserRepo {
	Boolean getUser(User user);
	
	Boolean add(User user);
	
	List<User> findAllUser();
}
