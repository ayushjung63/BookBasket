package BookBasket.controller;
import static spark.Spark.*;

import com.google.gson.Gson;

import BookBasket.model.UserOrder;
import BookBasket.utils.ServiceFactory;

public class OrderController {
	
	public static void orderBook() {
		post("/api/order/addorder",(req,res)->{
			UserOrder order=new Gson().fromJson(req.body(),UserOrder.class);
			return ServiceFactory.getOrderService().addOrder(order);
		});
	}
	
	public static void getAllOrder() {
		get("/api/order/allorder",(req,res)->{
			return new Gson().toJson(ServiceFactory.getOrderService().allOrder());
		});
	}
	
	public static void getParticularOrder() {
		get("/api/order/:id",(req,res)->{
			int id=Integer.parseInt(req.params("id"));
			return new Gson().toJson(ServiceFactory.getOrderService().getParticularUserOrder(id));
		});
	}
	
	public static void cancelOrder() {
		get("/api/order/cancel/:id",(req,res)->{
			int id=Integer.parseInt(req.params("id"));
			return ServiceFactory.getOrderService().cancelOrder(id);
		});
	}
	
	public static void initOrderController() {
		orderBook();
		getAllOrder();
		getParticularOrder();
		cancelOrder();
	}
}
