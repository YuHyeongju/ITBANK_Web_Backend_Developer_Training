package variable;

public class Ex04 {

	public static void main(String[] args) {
		//기본자료형(primitive type)
		//자바는 객체지향 언어이므로, 모든 값은 객체 형태로 나타내어야함.
		//이때 객체란, 데이터와 함수가 결합되어 있는 형태
		//그러나 기본 자료형은 함수 없이 순수 데이터만으로 구성되어있다.
		//그래서 원시 자료형이라는 이름을 사용
		
		String name = "이지은";
		int age = 31;
		
		byte by = 127;
		boolean bo = true;
		short sh = 32767;
		char ch = 44032;
		long ln = 30000000L; //기본자료형이 아니기때문에 long임을 명시
		float fl = 1.2f;	 //기본자료형이 아니기때문에 float임을 명시
		double db = 3.14;
		
		//The value of the local variable bo is not used
		//지역 변수 bo는 아직 사용되어지지 않았다.
		//컴파일러가 만들어놓고 안썼냐고 물어본다.
		
		System.out.println(name);
		System.out.println(by);
		System.out.println(bo);
		System.out.println(sh);
		System.out.println(ch);
		System.out.println(age);
		System.out.println(ln);
		System.out.println(fl);
		System.out.println(db);
	
		//대입: 오른쪽의 값을 왼쪽 변수 공간에 복사하여 저장
		//왼쪽과 오른쪽의 값은 같지 않아도 되지만, 자료형은 동일해야함.
		
		//이미 선언된 변수는 자료형이 나타나지 않지만, 툴팁이나 링크 따라가기 등으로 확인 가능 :ctrl + 마우스올려놓기
		
		//age = "배고파";
		
		//양쪽 다 변수를 나타내고 있지만 오른쪽의 변수는 변수에 담긴 값을 의미, 왼쪽의 변수는 변수 공간 그 자체를 의미한다.
		
		//sh = ch; sh는 숫자를 담기 위한 자료형 ch는 문자를 담기 위한 자료형이다. 
		
		//왼쪽과 오른쪽의 자료형이 맞지않아서 대입이 안되니, 자료형을 강제로 맞추면 대입 가능(캐스팅)
		//단, 이때 값의 보전 여부는 보장할 수 없다.
		sh = (short)ch;
		System.out.println("sh : " + sh);

	}

}
