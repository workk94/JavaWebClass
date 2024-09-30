package mytest.ajax연습;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

public class FoodService {
	//메뉴정보 가져오기, Json
	//메뉴정보리스트가져오기, Json
	
	FoodDAO dao = new FoodDAO();
	
	public JSONArray getMenuListJson() {
		ArrayList<Food> list = new ArrayList<>();
		list.add(new Food("오므라이스", 4000));
		list.add(new Food("돈까스", 10000));
		list.add(new Food("비빔밥", 8000));

		// list => jsonArray로 변환
		
		
		JSONArray arr = new JSONArray();
		
		for(Food food : list ) {
			//JSONObject 변환
			//JSONArray에 추가 
			JSONObject o = new JSONObject();
			o.put("name", food.getName());
			o.put("price", food.getPrice());
			
			arr.put(o);
		}
		
		return arr;
	}
	
	
	public JSONArray getMenuListJsonReal() {
		ArrayList<Food> list = dao.getFoodList();
		
		// json 변환 
		
		JSONArray arr = new JSONArray();
		
		for(Food food : list) {
			//JSONObject 변환
			//JSONArray 추가 
			
			JSONObject o = new JSONObject();
			o.put("name", food.getName());
			o.put("price", food.getPrice());
			
			arr.put(o);
		}
		return arr;
	}
	
	public static void main(String[] args) {
		FoodService service = new FoodService();
		JSONArray list = service.getMenuListJsonReal();
		System.out.println(list);
	}
}
