package model;

import java.util.ArrayList;

public class ShopService {
	ReviewDAO rdao = new ReviewDAO();	
	ProductDAO pdao = new ProductDAO();
	
	// 유저 리뷰
	public ArrayList<Review> getUserReview(String id){
		return rdao.selectAllByUserId(id);
	}
	
	
	// 상품 출력
	public ArrayList<Product> getAllproduct(){
		return pdao.selectAll();
	}
	
	// 리뷰 수정
	
	
}
