package model;

public class OrderItem {
	
	private String item_no;
	private String order_id;
	private String product_no;
	private int quantity;
	private String item_size;
	
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
	
	public OrderItem(String item_no, String order_id, String product_no, int quantity, String item_size) {
		super();
		this.item_no = item_no;
		this.order_id = order_id;
		this.product_no = product_no;
		this.quantity = quantity;
		this.item_size = item_size;
	}
	
	@Override
	public String toString() {
		return "OrderItem [item_no=" + item_no + ", order_id=" + order_id + ", product_no=" + product_no + ", quantity="
				+ quantity + ", item_size=" + item_size + "]";
	}

}
