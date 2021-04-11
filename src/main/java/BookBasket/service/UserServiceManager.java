package BookBasket.service;

import java.util.List;

import javax.persistence.EntityManager;

import BookBasket.Repo.UserRepo;
import BookBasket.model.Error;
import BookBasket.model.User;
import BookBasket.model.UserDTO;
import BookBasket.utils.RepoFactory;
import BookBasket.utils.SessionFactory;
import BookBasket.utils.UserFactory;

public class UserServiceManager implements UserService {
	

	private UserRepo userRepo;
	
	public UserServiceManager() {
		this.userRepo=RepoFactory.getUserRepo();
	}
	
	@Override
	public int count() {
		return userRepo.countUser();
	}

	@Override
	public UserDTO login(User u) {
		User loggedUser= userRepo.getUser(u);
		if(loggedUser!=null) {
			UserDTO userdto=new UserDTO();
			userdto.setId(loggedUser.getId());
			userdto.setUsername(loggedUser.getUsername());
			userdto.setAddress(loggedUser.getAddress());
			userdto.setContact(loggedUser.getContact());
			userdto.setEmail(loggedUser.getEmail());
			return userdto;
		}
		return null;
	}

	@Override
	public Boolean addUser(User user) {
		User loggedUser= userRepo.getUser(user);
		if(loggedUser==null) {
			return userRepo.add(user);
		}else {
			return false;
		}
	}

	@Override
	public List<User> viewAllUser() {
		return userRepo.findAllUser();
	}
	
	
}
