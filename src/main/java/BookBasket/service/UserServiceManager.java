package BookBasket.service;

import java.sql.SQLOutput;
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
	public boolean deleteUser(int id) {
		return userRepo.deleteUser(id);
	}

	@Override
	public UserDTO login(User u) throws Exception {
		User loggedUser= userRepo.getUser(u);
		System.out.println(loggedUser);
		if(loggedUser==null)
			throw new Exception("No such user exists.");
		String dbPw=PasswordEncoder.decrypt(loggedUser.getPassword());
		if(u.getPassword().equals(dbPw)) {
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
		String encodedpw=PasswordEncoder.encrypt(user.getPassword());
		user.setPassword(encodedpw);
		System.out.println(encodedpw);
		return userRepo.add(user);
	}

	@Override
	public List<User> viewAllUser() {
		return userRepo.findAllUser();
	}

	@Override
	public Boolean checkUserByEmail(String email) {
		return userRepo.checkUserExistsByEmail(email);
	}

	@Override
	public Boolean checkUserByUsername(String username) {
		System.out.println(username);
		return userRepo.checkUserExistsByUsername(username);
	}
	
}
