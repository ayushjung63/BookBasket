package BookBasket.Repo;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.SessionFactory;

import BookBasket.model.UserOrder;

public class OrderRepoManager implements OrderRepo {
	private SessionFactory sessionFactory;
	private EntityManager session;
	
	public OrderRepoManager(){
		sessionFactory=BookBasket.utils.SessionFactory.getInstance();
	}
	
	@Override
	public 	boolean addOrder(UserOrder order) {
		try {
			session = sessionFactory.createEntityManager();
			session.getTransaction().begin();
			session.persist(order);
			session.getTransaction().commit();
			if (session.isOpen()) {
				session.close();
			}
			return true;
		}catch (Exception e){
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<UserOrder> getAllOrder() {
		session=sessionFactory.createEntityManager();
		session.getTransaction().begin();
		List<UserOrder> allOrder=session.createQuery("From UserOrder",UserOrder.class).getResultList();
		session.getTransaction().commit();
		if(session.isOpen()) {
			session.close();
		}
		return allOrder;
	}

	@Override
	public void getUserOrder(int id) {
		/*
		 * session=sessionFactory.createEntityManager();
		 * session.getTransaction().begin(); List<UserOrder>
		 * allOrder=session.createNamedQuery(null); session.getTransaction().commit();
		 * if(session.isOpen()) { session.close(); } return allOrder;
		 */

	}

	@Override
	public void cancelOrder(UserOrder order) {
		// TODO Auto-generated method stub
		
	}

}
