package mytest.ajax연습;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

public class MovieService {
	MovieDAO dao = new MovieDAO();
	
	public JSONArray getMovieList() {
		ArrayList<Movie> list = dao.selectAll();
		
		JSONArray arr = new JSONArray();
		
		for(Movie movie : list) {
			JSONObject obj = new JSONObject();
			obj.put("title", movie.getTitle());
			obj.put("director", movie.getDirector());
			obj.put("genre", movie.getGenre());
			obj.put("runningTime", movie.getRunningTime());
			arr.put(obj);
		}
		
		return arr;
	}
	
	
	public static void main(String[] args) {
		MovieService service = new MovieService();
		JSONArray arr = service.getMovieList();
		
		System.out.println(arr);
	}
}
