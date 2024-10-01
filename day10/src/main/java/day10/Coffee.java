package day10;

public class Coffee {
	private String name;
	private int price;
	private String size;
	
	public Coffee() {
		// TODO Auto-generated constructor stub
	}
	
	public Coffee(String name, int price, String size) {
		super();
		this.name = name;
		this.price = price;
		this.size = size;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return "Coffee [name=" + name + ", price=" + price + ", size=" + size + "]";
	}
	
}
