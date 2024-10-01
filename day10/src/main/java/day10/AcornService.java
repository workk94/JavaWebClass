package day10;

import java.util.ArrayList;

public class AcornService {
	public ArrayList<Acorn> getList(){
		ArrayList<Acorn> list = new ArrayList<>();
		
		list.add(new Acorn("test", "1234", "테스트1"));
		list.add(new Acorn("test2", "0000", "테스트2"));
		list.add(new Acorn("test3", "6782", "테스트3"));
		list.add(new Acorn("test4", "2423", "테스트4"));
		
		return list;
	}
	

}