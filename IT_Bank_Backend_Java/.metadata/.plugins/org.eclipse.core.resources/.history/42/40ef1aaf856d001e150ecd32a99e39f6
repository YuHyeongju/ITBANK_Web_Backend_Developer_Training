package control;

import java.util.Random;

public class Quiz01 {

	public static void main(String[] args) {
		//	게시글 데이터의 총 개수가 주어지면 
		//	여러 게시글을 총 몇 개의 페이지로 나누어서 불러와야 할지 계산하여 출력하세요.
		// - 페이지 당 게시글 출력 개수는 10개다.
		// - 하나의 게시글이라도 생략되면 안된다.
		// - 총 게시글 수는 10000 ~ 99999사이다.
		// - 요청으로 읽어들여야 할 게시글의 페이지 번호가 제시된다.
		// - 출력으로 불려와야 할 게시글의 번호를  n번부터 n + 10 까지 가져와야함.
		
		Random ran = new Random();
		int boardCount = ran.nextInt(89999) + 10000;
		
		int pageCount = boardCount / 10;		//한 페이지당 10개의 글을 넣으니까 나눈다.
		if(boardCount % 10 != 0) {
			pageCount += 1; 					// 딱 나누어 떨어지지않고 게시글이 남으면 1페이지 추가
		}
		
 		int page = ran.nextInt(pageCount) + 1; // 페이지 개수 범위 안에서 특정 페이지를 요청한다.
		int begin = 0 , end = 0;
		
		//begin = (page - 1) * 10 + 1 ;  // 결과는 동일 
		begin = (page * 10) - 9;		 // 시작값 
		end = begin + 9;			 	 // begin을 이용하여 end를 구하는 식
		
		if(end >= boardCount) end = boardCount;
		
		System.out.println("총 게시글 개수: " + boardCount);
		System.out.println("요청받은 페이지: " + page);
		System.out.printf("%d개의 게시글에서 %d페이지를 요청받았음으로, \n", boardCount, page);
		System.out.printf("%d번 부터 %d번 게시글을 불러와서 출력하면 된다. \n", begin, end);
 
	}

}
