package date;

import java.util.Date;

public class Ex01 {

	public static void main(String[] args) {
		// 클래스 import 선언을 하지않고 패키지 + 클래스 이름으로 전체이름을 다 지정하여 사용할 수 있다.
		// Date 클래스의 기본생성자 객체는 객체가 생성된 시점의 날짜 및 시간을 저장하고 있다.
		java.util.Date d1 = new Date();
		
		System.out.println("d1 : "  + d1);
		
		long ln1 = d1.getTime();		// 날짜 객체의 내부 64비트 정수를 추출한다.
		
		System.out.println("ln1: "  + ln1);
		
		
		// 생서자 호출시 long값을 전달하여 임의의 날짜 객체를 생성할 수도 있다.
		java.util.Date d2 = new java.util.Date(0); // 0 넣으면 기준시로 초기화 해줌
		System.out.println("d2 : " + d2);
		
		long ln2 = d2.getTime();  // 영국 그리니지 천문대 시간을 기준으로 출력
								  // date를 밀리세컨드로 변환해서 long형 숫자데이터로 반환
		System.out.println("ln2 : " + ln2);
		
		// 자바의 날짜는 밀리세컨드 단위로 계산함.

	}

}
