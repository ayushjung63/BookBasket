package BookBasket.service;

import java.util.List;

import javax.persistence.EntityManager;

import BookBasket.Repo.UserRepo;
import BookBasket.model.User;
import BookBasket.utils.RepoFactory;
import BookBasket.utils.SessionFactory;
import BookBasket.utils.UserFactory;

public class UserServiceManager implements UserService {
	private UserRepo userRepo;
	
	public UserServiceManager() {
		this.userRepo=RepoFactory.getUserRepo();
	}

	@Override
	public User checkUser(User u) {
		return userRepo.getUser(u);
	}

	@Override
	public Boolean addUser(User user) {
		userRepo.add(user);
		return true;
	}

	@Override
	public List<User> viewAllUser() {
		return userRepo.findAllUser();
	}
	
	
}
