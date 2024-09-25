package day05;

public class 가변인자 {
	//
	public void a(String a) {
		System.out.println(a);
	}
	
	//가변인자 
	public void b(String ...strings) {
		for(String str : strings) {
			System.out.println(str);
		}
	}
	
	public static void main(String[] args) {
		가변인자 obj = new 가변인자();
		
		obj.a("안녕");
		
		//가변인자 
		obj.b("안녕");
		obj.b("안녕", "hi");
		obj.b("안녕", "hi", "hello");
	}
}
