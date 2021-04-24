package BookBasket.Repo;

import java.util.List;

import BookBasket.model.UserOrder;

public interface OrderRepo {
	boolean addOrder(UserOrder order);
	boolean checkIfOrderExists(UserOrder order);
	List<UserOrder> getAllOrder();
	List<UserOrder> getUserOrder(int id);
	boolean cancelOrder(int id);
	UserOrder getOneOrder(int id);
	boolean delete(int id);
	int countOrder();
	
	List<UserOrder> getUserDetails(int id);
}
