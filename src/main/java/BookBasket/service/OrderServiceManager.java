package BookBasket.service;

import java.util.List;

import BookBasket.Repo.OrderRepo;
import BookBasket.model.UserOrder;
import BookBasket.utils.RepoFactory;

public class OrderServiceManager implements OrderService{
	private OrderRepo orderRepo;
	
	public OrderServiceManager() {
		this.orderRepo=RepoFactory.getOrderRepo();
	}
	
	@Override
	public boolean addOrder(UserOrder order) {
		return orderRepo.addOrder(order);
	}

	@Override
	public List<UserOrder> allOrder() {
		return orderRepo.getAllOrder();
	}

	@Override
	public void getParticularUserOrder(String id) {
		// TODO Auto-generated method stub
		
	}

}
