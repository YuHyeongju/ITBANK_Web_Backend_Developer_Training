package date;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Ex02 {

	public static void main(String[] args) throws Exception {
		
		// java.sql.Date의 toString은 YYYY-MM-dd 형식을 출력하게 되어있음.
		// java.sql.Date의 생성자는 반드시 long값을 전달해야한다.(기본생성자 없음)
		java.sql.Date d1 = new Date(0);
		System.out.println("d1: " + d1);
		
		// java.sql.Date는 java.util.Date의 서브클래스이다.
		java.util.Date d2 = new java.util.Date();
		System.out.println("d2: " + d2);
		
		java.sql.Date d3 = new java.sql.Date(d2.getTime());
		System.out.println("d3: " + d3); // 오늘 날짜 출력 - util.Date를 만들어서 sql.Date에 넣어줌
		
		// java.text.simpleDateFormat을 이용하여 문자열 <-> 날짜 형식을 활용할 수 있음.
		/*
		 * y: year 연도
		 * M: Month 월
		 * d: date 	일
		 * h: hours	시
		 * m: minute 분
		 * s: seconds 초
		 * a: am/pm 오전 오후
		 * 
		 * */
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date d4 = sdf.parse("1993-05-16"); //문자열을 util.Date로 변환
		System.out.println("d4: " + d4);
		java.sql.Date d5 = new java.sql.Date(d4.getTime()); // d4에서 만든 util시간을 sql시간에 대입
		System.out.println("d5: " + d5);
		
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy년-MM월-dd일 a hh시 mm분 ss초"); // 12시간 (a는 오전/오후)
		String s1 = sdf2.format(d5);				// 이미 만들어진 날짜를 상세하게 쓰고 싶을때
		System.out.println("s1: " + s1);
		
		String s2 = sdf2.format(new java.util.Date());
		System.out.println("s2 : " + s2);
		
		SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // 24시간 형태(a 없음)
		String s3 = sdf3.format(d5);
		d4.setTime(d4.getTime() + 1000 * 60 * 60 *14); // 밀리세컨드 60초 60분 14시간
		String s4 = sdf3.format(new java.util.Date());
		System.out.println(s3);
		System.out.println(s4);
		
		
		// SimpleDateFormat에서 많이 쓰는 함수 : parse, format
		
		
		
	}

}
