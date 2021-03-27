package BookBasket.Repo;

import java.util.List;

import BookBasket.model.UserOrder;

public interface OrderRepo {
	boolean addOrder(UserOrder order);
	List<UserOrder> getAllOrder();
	void getUserOrder(int id);
	void cancelOrder(UserOrder order);
}
