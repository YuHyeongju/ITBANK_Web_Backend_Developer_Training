package operater;

public class Ex03 {
	public static void main(String[] args) {
		// 비교 연산
		// >, <, >=, <=, == , !=
		// 초과, 미만, 이상, 이하, 일치, 불일치
		
		// 정수 혹은 실수값의 크기를 비교하여 그 결과를 boolean타입의 값으로 나타낸다.
		// (파이썬과 달리, 문자열의 크기 비교 지원안함.)
		// "Robert" > "Chris" (x)
		
		int n1 = 10;
		int n2 = 3;
		
		System.out.println("10 > 3 : " + (10 > 3));
		System.out.println("10 < 3 : " + (10 < 3));
		System.out.println("10 >= 3 : " + (10 >= 3));
		System.out.println("10 <= 3 : " + (10 <= 3));
		System.out.println("10 == 3 : " + (10 == 3));
		System.out.println("10 != 3 : " + (10 != 3));
		System.out.println();
		
		String s1 = "Hello";
		String s2 = new String("Hello");
		String s3 = "Hello";
		
		System.out.println("s1 : " + s1);
		System.out.println("s2 : " + s2);
		System.out.println("s3 : " + s2);
		
		System.out.println("s1==s2: " + (s1==s2));
		System.out.println("s2==s3: " + (s2==s3));
		System.out.println("s1==s3: " + (s1==s3));
		//연산자로는 문자열의 크기를 판별할 수 없다.
		System.out.println(s1.equals(s2)); //문자열을 비교하는 기능
		System.out.println();
		
		int age = 25;
		boolean isAdult = age >= 20;
		//비교 연산의 결과값을 boolean타입의 변수에 저장해놓았다가
		
		if(isAdult) { //제어문 (분기문)의 조건으로 활용됨.
			System.out.println("성인입니다.");
		}else {
			System.out.println("미성년자입니다.");
		}
	}
}
