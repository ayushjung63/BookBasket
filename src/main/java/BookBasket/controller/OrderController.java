package BookBasket.controller;
import static spark.Spark.*;

import com.google.gson.Gson;

import BookBasket.model.UserOrder;
import BookBasket.utils.ServiceFactory;

public class OrderController {
	
	public static void orderBook() {
		post("/api/order",(req,res)->{
			UserOrder order=new Gson().fromJson(req.body(),UserOrder.class);
			System.out.println(order);
			return ServiceFactory.getOrderService().addOrder(order);
		});
	}
	
	public static void getAllOrder() {
		get("/api/allorder",(req,res)->{
			return ServiceFactory.getOrderService().allOrder();
		});
	}
	
	public static void initOrderController() {
		orderBook();
		getAllOrder();
	}
}