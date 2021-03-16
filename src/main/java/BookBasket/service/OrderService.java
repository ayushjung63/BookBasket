package BookBasket.service;

import BookBasket.model.Book;
import BookBasket.model.Order;
import BookBasket.utils.ServiceFactory;

public class OrderService {
	
	public boolean orderBook(int userId,int bookId){
		Book book=ServiceFactory.getBookService().viewById(bookId);//db call
		if(book.getAvailable().equals("false")) return false;
		book.setAvailable("false");
		/*
		 * ServiceFactory.getBookService().update(Book b);//db call
		 */		Order order=new Order();
		order.setBookId(bookId);
		order.setUserId(userId);
		addOrder(order);
		return true;
	}
	
	public boolean addOrder(Order order) {
		//create order
		return false;
	}
}
