package BookBasket.Repo;

import javax.persistence.EntityManager;

import org.hibernate.SessionFactory;

import BookBasket.model.Admin;

public class AdminRepoManager implements AdminRepo {
	private SessionFactory sessionFactory;
	private EntityManager session;
	
	public AdminRepoManager() {
		sessionFactory=BookBasket.utils.SessionFactory.getInstance();
	}
	
	
	@Override
	public Boolean add(Admin admin) {
		session=sessionFactory.createEntityManager();
		session.getTransaction().begin();
		session.persist(admin);
		session.getTransaction().commit();
		if(session.isOpen()) {
			session.close();
		}
		return true;
	}

	@Override
	public Boolean findAdmin(String username) {
		return null;
	}

}
