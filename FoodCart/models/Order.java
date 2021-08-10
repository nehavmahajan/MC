package models;

import java.util.UUID;

public class Order {
	private UUID orderId;
	private String restoName;
	private int quantity;
	private String userId;
	public Order() {}
	public Order(UUID orderId, String restoName, int quantity,String userId) {
		this.orderId  = orderId;
		this.quantity = quantity;
		this.restoName = restoName;
		this.setUserId(userId);
	}
	public UUID getOrderId() {
		return orderId;
	}
	public void setOrderId(UUID orderId) {
		this.orderId = orderId;
	}
	public String getRestoName() {
		return restoName;
	}
	public void setRestoName(String restoName) {
		this.restoName = restoName;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
}
