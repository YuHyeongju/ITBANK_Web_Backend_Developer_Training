package control;

public class Ex02 {

	public static void main(String[] args) {
		//if : 조건이 참이면 종속 문장을 실행한다.
		
		int age = 25;
		if /* <- 제어문 */ (age >= 20);/* <- 조건절 */{
			// 종속 문장 : 한 줄일 수 있고, 여러 줄일 수 있다.
			// 종속문장이 여러 줄이면 , 반드시{} 를 이용하여 묶어줌.
			// 종속문장이 한 줄이면 {} 를 생략할 수 있지만, 권장하지 않음.
			
			System.out.println("성인입니다.");
 		}
		
		// 조건절은 아직 문장이 끝난 상태가 아니다.
		// 따라서, 조건절 다음에 ;을 작성하지 않아야함.
		System.out.println('끝');
		
		//세미콜론을 쓸 수 있는 경우
		if(age % 2 != 0);{
		System.out.println("홀수");
		}
		System.out.println("끝");

	}

}
