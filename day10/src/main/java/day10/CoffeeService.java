package day10;

import java.util.ArrayList;

public class CoffeeService {

	public ArrayList<Coffee> getCoffeeList(){
		ArrayList<Coffee> list = new ArrayList<>();
		list.add(new Coffee("아메리카노", 1900, "tall"));
		list.add(new Coffee("까페라떼", 2800, "grande"));
		list.add(new Coffee("콜드브루", 1900, "venti"));
		return list;
	}
}
