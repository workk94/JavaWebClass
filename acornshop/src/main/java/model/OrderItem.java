package model;

public class OrderItem {
	
	private String item_no;
	private String order_id;
	private String product_no;
	private int quantity;
	private String item_size;
	private String user_id;
	private String order_date;
	private String product_name;
	private int amount;
	
	public String getItem_no() {
		return item_no;
	}
	public void setItem_no(String item_no) {
		this.item_no = item_no;
	}
	public String getOrder_id() {
		return order_id;
	}
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
	public String getProduct_no() {
		return product_no;
	}
	public void setProduct_no(String product_no) {
		this.product_no = product_no;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getItem_size() {
		return item_size;
	}
	public void setItem_size(String item_size) {
		this.item_size = item_size;
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
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	public OrderItem(String item_no, String order_id, String product_no, int quantity, String item_size, String user_id, String order_date, String product_name, int amount) {
		super();
		this.item_no = item_no;
		this.order_id = order_id;
		this.product_no = product_no;
		this.quantity = quantity;
		this.item_size = item_size;
		this.user_id = user_id;
		this.order_date = order_date;
		this.product_name=  product_name;
		this.amount = amount;
	}
	
	@Override
	public String toString() {
		return "OrderItem [item_no=" + item_no + ", order_id=" + order_id + ", product_no=" + product_no + ", quantity="
				+ quantity + ", item_size=" + item_size + ", user_id=" + user_id + ", order_date=" + order_date
				+ ", product_name=" + product_name + ", amount=" + amount + "]";
	}
	
}
