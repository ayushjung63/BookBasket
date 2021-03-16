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
	public User findUser(String username) {
		session=sessionFactory.createEntityManager();
		session.getTransaction().begin();
		User user=(User) session.createQuery("from Book where username=username",User.class);
		session.getTransaction().commit();
		if(session.isOpen()) {
			session.close();
		}
		return user;
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

}
