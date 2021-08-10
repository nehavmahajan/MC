package services;

import java.util.UUID;
import java.util.Vector;

import models.Order;
import repository.DB;

public class OrderServiceImpl {
	
	private static OrderServiceImpl orderServiceImpl =null;
	private OrderServiceImpl() {	
	}
	
	public static OrderServiceImpl getInstance() {
		if(orderServiceImpl == null) {
			return new OrderServiceImpl();
		}
		else {
			return orderServiceImpl;
		}
	}
	
	/*------------------------------------------------------------------------------------------------*/
	
	public void placeOrder(String userID,String restaurantName, int quantity) {
		UUID orderId = UUID.randomUUID();
		Order o1 = new Order(orderId,restaurantName, quantity,userID);
		DB.getUserMap().get(userID).getOrder().add(o1);
		DB.getOrders().add(o1);
		if(DB.getRestoMap().get(restaurantName).getQuantity() < quantity) {
			System.out.println("\nQuantity is not valid! order cant be placed");
			return;
		}
		DB.getRestoMap().get(restaurantName).setQuantity(
				DB.getRestoMap().get(restaurantName).getQuantity()-quantity);
		System.out.println("\nOrder placed! ");
	}
	
	/*-------------------------------------------------------------------------------------------------*/
	
	public void showMyOrders(String userID) {
		System.out.println("\nMy Orders "+ userID );
		Vector<Order> order = DB.getOrders();
		
		for(Order o : order) {
			if(o.getUserId() == userID) {
				System.out.println("Restaurant :"+o.getRestoName() +",Quantity: "+o.getQuantity()+"");
			}
		}
	}
	
}
