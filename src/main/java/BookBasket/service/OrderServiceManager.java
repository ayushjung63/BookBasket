package BookBasket.service;

import java.util.List;

import BookBasket.Repo.BookRepo;
import BookBasket.Repo.OrderRepo;
import BookBasket.model.Book;
import BookBasket.model.Book.Status;
import BookBasket.model.UserOrder;
import BookBasket.utils.RepoFactory;

public class OrderServiceManager implements OrderService{
	private OrderRepo orderRepo;
	private BookRepo bookRepo;
	
	public OrderServiceManager() {
		this.orderRepo=RepoFactory.getOrderRepo();
		this.bookRepo=RepoFactory.getBookRepo();
	}
	
	@Override
	public boolean addOrder(UserOrder order) {
		Book book=bookRepo.findById(order.getBook().getId());
		if(book==null) {
			return false;
		}else if(book.getStatus().equals(Status.BOOKED)){
			return false;
		}
		else {
			bookRepo.bookBook(order.getBook());
			order.setStatus(1);
			return orderRepo.addOrder(order);
		}
	}

	@Override
	public List<UserOrder> allOrder() {
		return orderRepo.getAllOrder();
	}

	@Override
	public List<UserOrder> getParticularUserOrder(int id) {
		return orderRepo.getUserOrder(id);
	}

	@Override
	public boolean cancelOrder(int id) {
		return orderRepo.cancelOrder(id);
	}

}
