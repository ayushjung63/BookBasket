package BookBasket.Repo;

import java.util.List;

import javax.persistence.EntityManager;

import BookBasket.model.Book;
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
		session=sessionFactory.createEntityManager();
		session.getTransaction().begin();
		User dbUser=null;
		try {
			dbUser = (User) session.createNamedQuery("findUserByUsername", User.class)
					.setParameter("username", user.getUsername()).getSingleResult();
		}catch(Exception e){
			dbUser=null;
		}
		 session.getTransaction().commit();
		if(session.isOpen()) {
			session.close();
		}
		return dbUser;
	}

	@Override
	public Boolean deleteUser(int id) {
		session=sessionFactory.createEntityManager();
		session.getTransaction().begin();
		User user=session.find(User.class, id);
		System.out.println(user);
		session.remove(user);
		session.getTransaction().commit();
		if(session.isOpen()) {
			session.close();
		}
		return true;
	}
	
	

	@Override
	public User findUserById(int id) {
			session=sessionFactory.createEntityManager();
			session.getTransaction().begin();
			User user=session.find(User.class, id);

			if(session.isOpen()) {
				session.close();
			}
			return user;
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

	@Override
	public int countUser() {
		session=sessionFactory.createEntityManager();
		session.getTransaction().begin();
		List<User> allUser=session.createQuery("from User",User.class).getResultList();
		session.getTransaction().commit();
		if(session.isOpen()) {
			session.close();
		}
		int count=allUser.size();
		return count;
	}

	@Override
	public boolean checkUserExistsByEmail(String email) {
		session = sessionFactory.createEntityManager();
		session.getTransaction().begin();
		User result=null;
		try {
			result = session.createNamedQuery("findUserByEmail", User.class)
					.setParameter("email", email).getSingleResult();
			session.getTransaction().commit();
		}catch(Exception e){
			result=null;
		}
		if(result!=null){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean checkUserUsername(User user) {
		System.out.println("Repo");
		session=sessionFactory.createEntityManager();
		session.getTransaction().begin();
		User dbUser=null;
		try {
			dbUser = (User) session.createNamedQuery("findUserByUsername", User.class)
					.setParameter("username", user.getUsername()).getSingleResult();
		}catch(Exception e){
			e.printStackTrace();
			dbUser=null;
		}
		session.getTransaction().commit();
		if(session.isOpen()) {
			session.close();
		}
		if(dbUser!=null){
			return  true;
		}else{
			return  false;
		}
	}
}
