package model;

public class Product {
	
	//수정했음
	private String product_name;
	private String brand_name;
	private String category;
	private int price;
	private String img_url;
	
	public Product(String product_name, String brand_name, String category, int price, String img_url) {
		super();
		this.product_name = product_name;
		this.brand_name = brand_name;
		this.category = category;
		this.price = price;
		this.img_url = img_url;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getBrand_name() {
		return brand_name;
	}

	public void setBrand_name(String brand_name) {
		this.brand_name = brand_name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getImg_url() {
		return img_url;
	}

	public void setImg_url(String img_url) {
		this.img_url = img_url;
	}

	@Override
	public String toString() {
		return "Product [product_name=" + product_name + ", brand_name=" + brand_name + ", category=" + category
				+ ", price=" + price + ", img_url=" + img_url + "]";
	}
	
	

}
