package model;

import java.sql.Date;

public class Order {
	
	private String order_id;
	private String user_id;
	private String order_date;
	
	public String getOrder_id() {
		return order_id;
	}
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getOrder_date() {
		return order_date;
	}
	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}
	
	public Order(String order_id, String user_id, String order_date) {
		super();
		this.order_id = order_id;
		this.user_id = user_id;
		this.order_date = order_date;
	}
	
	@Override
	public String toString() {
		return "Order [order_id=" + order_id + ", user_id=" + user_id + ", order_date=" + order_date + "]";
	}
	
}
