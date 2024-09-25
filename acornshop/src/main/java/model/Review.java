package model;

public class Review {
	
	private String review_id;
	private String user_id;
	private String product_no;
	private String product_name;
	private String item_no;
	private String content;
	private String rating;
	
	public String getReview_id() {
		return review_id;
	}
	public void setReview_id(String review_id) {
		this.review_id = review_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getProduct_no() {
		return product_no;
	}
	public void setProduct_no(String product_no) {
		this.product_no = product_no;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getItem_no() {
		return item_no;
	}
	public void setItem_no(String item_no) {
		this.item_no = item_no;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	
	public Review(String review_id, String user_id, String product_no, String product_name, String item_no, String content, String rating) {
		super();
		this.review_id = review_id;
		this.user_id = user_id;
		this.product_no = product_no;
		this.product_name = product_name;
		this.item_no = item_no;
		this.content = content;
		this.rating = rating;
	}
	
	@Override
	public String toString() {
		return "Review [review_id=" + review_id + ", user_id=" + user_id + ", product_no=" + product_no
				+ ", product_name=" + product_name + ", item_no=" + item_no + ", content=" + content + ", rating="
				+ rating + "]";
	}

}
