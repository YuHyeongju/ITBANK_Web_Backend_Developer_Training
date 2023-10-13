package variable;

public class Quiz02 {

	public static void main(String[] args) {
		//자신의 이름을 문자열 변수에 저장하세요.
		String myname = "유형주";
		
		//자신의 나이를 정수형 변수에 저장하세요.
		int myage = 26;
		Integer myage1 = 26;
		
		//새로운 실수형 변수에 0을 대입하세요.
<<<<<<< HEAD
		double d_num = 0;	//우변의 0은 자료형이 명시 되지 않은 리터럴, 리터럴정수의 기본 자료형은 int이다. 
		//Double d_num1 = 0;  //Type mismatch: cannot convert from int to Double
		//Double d_num1 = 0.0;
		//Double d_num1 = (double)0
		Double d_num1 = Double.valueOf(0);
=======
		double d_num = 0;	//우변의 0은 자료형이 명시 되지 않은 리터럴, 리터럴 정수의 기본 자료형은 int이다. 
		//Double d_num1 = 0;  Type mismatch: cannot convert from int to Double
		//Double d_num1 = 0.0;
		//Double d_num1 = (double)0
		Double d_num1 = Double.valueOf(0);
		
>>>>>>> 603ecb2 (2023_10_12 자바 첫 업로드)
		//방금 만든 실수형 변수에 3.14를 대입하세요.
		d_num = 3.14;
		d_num1 = 3.14;
		
		//지금까지 만든 3개의 변수에 담긴 값을 각각 한 줄씩 화면에 출력하세요.
		//primitive를 이용해서 한 번, WrapperClass를 이용해서 한 번 코드를 실행하세요
		System.out.println(myname);
		System.out.println(myage);
		System.out.println(d_num);
		
		System.out.println();
		
		System.out.println(myname);
		System.out.println(myage1);
		System.out.println(d_num1);
	}

}
