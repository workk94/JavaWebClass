package day11;



public class PageHandler {
	
	
	// 페이지 사이즈  한 페이지 글 수
	// 페이지 그룹 사이즈  [1] [2] [3] [4 ]  [5]
	// 총레코드수
	// 현재페이지 
	
	// 총페이지수 
	// 현재그룹구하기
	// 현재그룹시작값 구하기 
	// 현재그룹마지막값 구하기 
	 
	
	
	 int pageSize;
	 int grpSize;
	 int totRecords;
	 int currentPage;
	 
	 int totalPage;
	 int currentGrp;
	 int grpStartPage;
	 int grpEnpPage;
	 
	 
	 
	public PageHandler(int pageSize, int grpSize, int totRecords, int currentPage) {
		super();
		this.pageSize = pageSize;
		this.grpSize = grpSize;
		this.totRecords = totRecords;
		this.currentPage = currentPage;
		
		
		calcPage();
	}
	
	
	private void calcPage() {
		
		//1. 총페이지수 구하기 
		//2. 현재페이지에 따른 현재그룹 구하기
		//현재그룹시작값
		//현재그룹마지막값
		
		
		//1.
		int  remain  = totRecords % pageSize;
		
		if( remain==0) {
			totalPage  = totRecords  / pageSize;
			
		}else {
			totalPage  = totRecords  / pageSize+1;
		}		
		
		
		
		//2.현재그룹구하기
		
		int remain2 =  currentPage % grpSize;    // 2 => 1그룹   6 => 2그룹
		
		if( remain2 ==0) {
			currentGrp =  currentPage  /grpSize ;	 
		}else {
			currentGrp =  (currentPage  /grpSize )  +1; //2  /5    => 몫은 0  ....2		  =>1
		}
		
		
		
		//3.현재그룹 시작, 끝 구하기 		
		
		grpStartPage =( currentGrp -1) *grpSize  +1;
		grpEnpPage = currentGrp * grpSize;
		
		
		
		//4. 그룹의 마지막값 확인하기 
		
		if(grpEnpPage  > totalPage ) {
			grpEnpPage  = totalPage;
		}
		
	}


	public int getPageSize() {
		return pageSize;
	}


	public int getGrpSize() {
		return grpSize;
	}


	public int getTotRecords() {
		return totRecords;
	}


	public int getCurrentPage() {
		return currentPage;
	}


	public int getTotalPage() {
		return totalPage;
	}


	public int getCurrentGrp() {
		return currentGrp;
	}


	public int getGrpStartPage() {
		return grpStartPage;
	}


	public int getGrpEnpPage() {
		return grpEnpPage;
	}
	
	public static void main(String[] args) {
		
		 //	public PageHandler(int pageSize, int grpSize, int totRecords, int currentPage) {
		
	 //	 PageHandler   page = new PageHandler(5, 4,46, 1);
		// PageHandler   page = new PageHandler(4, 5,37, 6);
	   //  PageHandler   page = new PageHandler(10, 4,153, 13);
		   PageHandler   page = new PageHandler(7, 6,513, 9);
	     
		 System.out.println( page.getTotalPage() );
		 System.out.println(page.getCurrentGrp());
		 System.out.println( page.getGrpStartPage() );
		 System.out.println( page.getGrpEnpPage() );
		
		 
		  
	}

}
