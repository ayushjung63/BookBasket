package BookBasket.service;

import java.util.List;

import BookBasket.Repo.BookRepo;
import BookBasket.Repo.OrderRepo;
import BookBasket.Repo.UserRepo;
import BookBasket.model.Book;
import BookBasket.model.Book.Delivery;
import BookBasket.model.Book.Status;
import BookBasket.model.User;
import BookBasket.model.UserOrder;
import BookBasket.utils.RepoFactory;

public class OrderServiceManager implements OrderService{
	

	private OrderRepo orderRepo;
	private BookRepo bookRepo;
	private UserRepo userRepo;
	
	public OrderServiceManager() {
		this.orderRepo=RepoFactory.getOrderRepo();
		this.bookRepo=RepoFactory.getBookRepo();
	}
	
	@Override
	public int count() {
		return orderRepo.countOrder();
	}
	
	@Override
	public boolean addOrder(UserOrder order) {
		System.out.println("here");
		Book book=bookRepo.findById(order.getBook().getId());
	
		if(book==null) {
			return false;
		}else if(book.getStatus().equals(Status.BOOKED)||book.getStatus().equals(Status.ADMINPENDING)){
			return false;
		}
		else{
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
		UserOrder order=orderRepo.getOneOrder(id); 
		orderRepo.cancelOrder(id);
		bookRepo.approveBook(order.getBook().getId());
		 return true;
	}

	@Override
	public boolean deleteOrder(int id) {
		return orderRepo.delete(id);
	}

	@Override
	public List<UserOrder> viewBookOrder(int id) {
		return orderRepo.getUserDetails(id);
	}
	
	
	
	

}
