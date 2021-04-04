package BookBasket.Repo;

import java.util.List;

import javax.persistence.EntityManager;

import BookBasket.model.User;
import BookBasket.utils.SessionFactory;

public class UserRepoManager implements UserRepo {
	private static org.hibernate.SessionFactory sessionFactory;
	private EntityManager session;
	
	public UserRepoManager() {
		sessionFactory=SessionFactory.getInstance();
	}
	
	@Override
	public Boolean add(User user) {
		session=sessionFactory.createEntityManager();
		session.getTransaction().begin();
		session.persist(user);
		session.getTransaction().commit();
		if(session.isOpen()) {
			session.close();
		}
		return true;
	}

	@Override
	public List<User> findAllUser() {
		session=sessionFactory.createEntityManager();
		session.getTransaction().begin();
		List<User> allUser=session.createQuery("from User",User.class).getResultList();
		session.getTransaction().commit();
		if(session.isOpen()) {
			session.close();
		}
		return allUser;
	}

	@Override
	public  User getUser(User user) {
		User result;
		session=sessionFactory.createEntityManager();
		session.getTransaction().begin();
		User dbUser=(User) session.createNamedQuery("findUserByUsername",User.class)
				.setParameter("username", user.getUsername()).getSingleResult();
		session.getTransaction().commit();
		if(session.isOpen()) {
			session.close();
		}
		if(user.getPassword().equals(dbUser.getPassword())) {
			result=dbUser;
			result.setPassword("");
			System.out.println(result);
		}else{
			result=null;
		}
		return result;
	}

	@Override
	public Boolean deleteUser(int id) {
		session=sessionFactory.createEntityManager();
		session.getTransaction().begin();
		User user=session.find(User.class, id);
		session.remove(user);
		if(session.isOpen()) {
			session.close();
		}
		return true;
	}

	@Override
	public User editUser(int id,User user) {
		session=sessionFactory.createEntityManager();
		session.getTransaction().begin();
		User dbUser=session.find(User.class, id);
		dbUser.setAddress(user.getAddress());
		dbUser.setContact(user.getContact());
		dbUser.setEmail(user.getEmail());
		return dbUser;
	}

	
	
	

}
