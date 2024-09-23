package prac;

public class DanService {
	
	
	public String getDan(int su) {
		// 2단 정보 => 데이터(모델)
		String result = "";

		for (int i = 1; i <= 9; i++) {
			String unit = su + "*" + i + "=" + su * i + "<br>";
			result += unit;

		}

		return result;
	}
	
	
	public static void main(String[] args) {
		DanService s = new DanService();
		String result = s.getDan(5);
		System.out.println(result);
		
		
		//extracted();
	}

	/*
	private static void extracted() {
		int su = 3;
		String result = "";

		for (int i = 1; i <= 9; i++) {
			String unit = su + "*" + i + "=" + su * i + "<br>";
			result += unit;

		}
	}
	*/
}
