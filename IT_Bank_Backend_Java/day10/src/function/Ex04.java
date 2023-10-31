package function;

public class Ex04 {

	// 원의 반지름을 전달받아서, 원의 넓이를 반환하는 함수
	static double getCircleArea(int radius) { // 반지름 정수
		double area = radius * radius * 3.14;

		return area;
	}

	static double getCircleArea(double radius) { // 반지름 실수
		double area = radius * radius * 3.14;
		return area;
	}

	public static void main(String[] args) {
		// 함수 오버로딩: 같은 이름의 함수에 여러 정의가 연결되어 있다.
		// 같은 이름으로 여러 함수가 중복 정의 될 수 있다.

		// ex1) 문자열의 substring 함수
		// 인자를 1개만 전달하면 beginIndex로 취급하여 지정한 위치부터 끝까지 잘라낸다.
		// 인자를 2개 전달하면 beginIndex와 endIndex로 취급하여 begin부터 end 이전까지 잘라낸다.

		String text = "Authentication Number is 132675";
		String s1 = text.substring(15); // 문자열을 잘라내고 싶다면 substring만 기억
		String s2 = text.substring(15, 21);

		System.out.println("s1 : " + s1);
		System.out.println("s2 : " + s2);

		// 오버로딩된 함수를 호출할 떄는 값만 넣으면 알아서 맞는 정의를 찾아간다.

		double d1 = getCircleArea(3);
		double d2 = getCircleArea(2.2);

		System.out.printf("d1: %.2f\n", d1);
		System.out.printf("d2: %.2f\n", d2);

		// 함수 오버로딩의 기준은 매개변수의 개수 및 자료형, 혹은 매개변수의 순서
		// 반환자료형은 오버로딩에 전혀 영향을 줄 수 없다.
	}

	static int add(int n1, int n2) { // 기본 정의
		return n1 + n2;
	}

	static int add(int n1, int n2, int n3) { // 개수가 다른 정의
		return n1 + n2;
	}

	static double add(int n1, double n2) { // 자료형이 다른 정의
		return n1 + n2;
	}

	static double add(double n1, int n2) { // 다른 자료형의 순서가 다른 정의
		return n1 + n2;
	}

	static String add(String n1, String n2) { // 자료형이 다른 정의
		return n1 + n2;
	}
}
//	static double add(int n1, int n2) {	// 첫번째 add와 반환형이 다르지만 
//		return n1 + n2;					// 매개변수의 자료형 및 개수, 순서가 정확히 일치한다.
//}										// 겹친다. (duplicate)