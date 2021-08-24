package BookBasket.Repo;

import java.util.List;

import BookBasket.model.User;

public interface UserRepo {
	User getUser(User user);
	
	Boolean add(User user);
	
	List<User> findAllUser();
	
	Boolean deleteUser(int id);
	
	User editUser(int id,User user);
	
	User findUserById(int id);
	
	int countUser();

	boolean checkUserExistsByEmail(String email);
	boolean checkUserExistsByUsername(String username);
}
