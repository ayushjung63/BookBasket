package BookBasket.Repo;

import java.util.List;

import BookBasket.model.UserOrder;

public interface OrderRepo {
	boolean addOrder(UserOrder order);
	List<UserOrder> getAllOrder();
	List<UserOrder> getUserOrder(int id);
	boolean cancelOrder(UserOrder order);
}
