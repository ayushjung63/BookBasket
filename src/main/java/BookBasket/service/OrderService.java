package BookBasket.service;

import java.util.List;

import BookBasket.model.User;
import BookBasket.model.UserOrder;

public interface OrderService {
	boolean addOrder(UserOrder order);
	List<UserOrder> allOrder();
	void getParticularUserOrder(String id);
}