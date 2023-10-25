package function;

public class Ex01 {
	//	함수의 정의(definition)
	// 	함수 이름:  multiple
	//  반환자료형: 함수이름 앞에 있는 int
	// 	매개변수: ()안에 있는 int n1, int n2, 지역변수의 특성을 가짐.
	static int multiple(int n1, int n2) {
		int answer = 0;			//함수의 몸체: 구체적인 실행내용 작성
		answer = n1 * n2;
		return answer;			// return은 함수의 종료를 의미함.
								// 함수가 종료 될 때 호출된 자리로 값을 돌려준다.
	}

	public static void main(String[] args) {
		
		//(10, 1/2) //0이 되지못한 값은 정수 범위에서 0으로 간주함.
		int result = multiple(10, 20);           	//함수의 호출, 함수 이름을 부르면서 값으 전달하여 실행
		System.out.println("result: " + result);
		
		int result2 = multiple(3, 4);
		System.out.println("result2 : " + result2); 
		
		// 함수: 자주 사용하는 코드에 이름을 지정하고 묶어서 필요할 떄마다 실행할수 있도록 만든 유형
		// 일반적인 함수는 하나의 값을 만드는 형식이다.

		// 함수의 정의: 함수를 사용하기 위해서 함수의 형식을 지정하고, 내용을 작성한다.

		// 함수의 호출 : 이미 만들어진 함수를 실행하기위해 이름을 지정하고, 내용을 작성한다.
		// 함수를 호출할 때 함수에 필요한 인자 값을 전달할 수 있음.

		// 인자: 함수 내용이 실행되기 위해서 필요한 값. 결과의 원인이 되는 값.
		// 매개변수: 함수 정의에서 ()안에 지정하는 변수. 인자값을 받기 위한 변수이다.
		// 반환자료형: 함수는 실행 종료 후 특정 값을 만들어내는데 이 값의 자료형을 반환자료형이라함.

	}

}
