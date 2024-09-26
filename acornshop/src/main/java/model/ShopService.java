package model;

import java.util.ArrayList;

public class ShopService {
	ReviewDAO rdao = new ReviewDAO();	
	ProductDAO pdao = new ProductDAO();
	OrderItemDAO idao = new OrderItemDAO();
	
	// 유저 리뷰
	public ArrayList<Review> getUserReview(String id){
		return rdao.selectAllByUserId(id);
	}
	
	
	// 상품 출력
	public ArrayList<Product> getAllproduct(){
		return pdao.selectAll();
	}
	
	// 리뷰id에 해당하는 리뷰 가져오기
	public Review getReview(String id) {
		return rdao.selectOne(id);
	}
	
	// 리뷰 수정
	public int updateReview(Review review, String newContent, String newRating) {
		return rdao.update(review, newContent, newRating);
	}
	
	// 주문 목록 가져오기
	public ArrayList<OrderItem> getUserOrder(String id){
		return idao.selectAllByUserId(id);
	}
	
	public ArrayList<Review> getAllReview() {
		return rdao.selectAll();
	}
	
	public int createReview(Review review) {
		return rdao.insert(review);
	}
	
}
