package BookBasket.Repo;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.SessionFactory;

import BookBasket.model.User;
import BookBasket.model.UserOrder;

public class OrderRepoManager implements OrderRepo {
	

	private SessionFactory sessionFactory;
	private EntityManager session;

	public OrderRepoManager() {
		sessionFactory = BookBasket.utils.SessionFactory.getInstance();
	}
	
	@Override
	public int countOrder() {
		session = sessionFactory.createEntityManager();
		session.getTransaction().begin();
		List<UserOrder> allOrder = session.createQuery("From UserOrder", UserOrder.class).getResultList();
		session.getTransaction().commit();
		if (session.isOpen()) {
			session.close();
		}
		return allOrder.size();
	}

	@Override
	public boolean addOrder(UserOrder order) {
		try {
			session = sessionFactory.createEntityManager();
			session.getTransaction().begin();
			session.persist(order);
			session.getTransaction().commit();
			if (session.isOpen()) {
				session.close();
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<UserOrder> getAllOrder() {
		session = sessionFactory.createEntityManager();
		session.getTransaction().begin();
		List<UserOrder> allOrder = session.createQuery("From UserOrder", UserOrder.class).getResultList();
		session.getTransaction().commit();
		if (session.isOpen()) {
			session.close();
		}
		return allOrder;
	}

	@Override
	public List<UserOrder> getUserOrder(int id) {
		User user=new User();
		user.setId(id);
		session = sessionFactory.createEntityManager();
		session.getTransaction().begin();
		List<UserOrder> allOrder = session.createNamedQuery("findParticularOrder",UserOrder.class)
				.setParameter("id",user).getResultList();
		session.getTransaction().commit();
		if (session.isOpen()) {
			session.close();
		}
		return allOrder;
	}

	@Override
	public boolean cancelOrder(int id) {
		session=sessionFactory.createEntityManager();
		session.getTransaction().begin();
		UserOrder order=session.find(UserOrder.class, id);
		order.setStatus(0);
		session.getTransaction().commit();
		return true;
	}
	
	

	@Override
	public boolean checkIfOrderExists(UserOrder order) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public UserOrder getOneOrder(int id) {
		session=sessionFactory.createEntityManager();
		session.getTransaction().begin();
		UserOrder order=session.find(UserOrder.class, id);
		session.getTransaction().commit();
		return order;
	}

	@Override
	public boolean delete(int id) {
		session=sessionFactory.createEntityManager();
		session.getTransaction().begin();
		UserOrder order=session.find(UserOrder.class, id);
		session.remove(order);
		session.getTransaction().commit();
		return true;
	}

	@Override
	public List<UserOrder> getUserDetails(int id) {
		User user=new User();
		user.setId(id);
		session = sessionFactory.createEntityManager();
		session.getTransaction().begin();
		List<UserOrder> allOrder = session.createNamedQuery("findbookOrder",UserOrder.class)
				.setParameter("user",user).getResultList();
		session.getTransaction().commit();
		if (session.isOpen()) {
			session.close();
		}
		return allOrder;
	}
	
	
	

	
}
