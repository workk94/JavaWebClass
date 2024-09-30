package food;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

public class MovieService {
	
	
	
	public  JSONObject   getMoviePaging( int page) {
		
		//영화정보  5개 
		
		ArrayList<Movie> list = new ArrayList<>();
		list.add(new Movie( "파묘" ,"김고은"));
		list.add(new Movie( "변호인" ,"송강호"));
		list.add(new Movie( "매트릭스" ,"키아누"));		 
		
		//=>json array  +   페이지 정보
		
		JSONArray arr =new JSONArray();		
		
		for( int i=0; i< list.size();i++) {			
			Movie m  = list.get(i);
			JSONObject  o = new JSONObject();
			o.put("title", m.getTitle());
			o.put("actor", m.getActor());			
			arr.put(o);
			 
		}		
		
		
		JSONObject   result = new JSONObject( );		
		result.put("list", arr);
		result.put("page", 2);
		result.put("total_page" ,10 );		
		
		
		
		
		return result;	
		
	}

}
