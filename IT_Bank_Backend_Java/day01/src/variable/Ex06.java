package variable;

public class Ex06 {

	public static void main(String[] args) {
		//여러 변수를 선언할 때, 자료형이 같다면 한 번에 선언할 수 있음.
		int n1 = 57, n2 = 32, n3 = 78;
		
		int total = n1 + n2 + n3;
		//double avg = total / 3;			암묵적 형 변환: int가 double로 바뀌면서 대입됨
		//double avg = total / (double)3;	명시적 형 변환: 계산전에 미리 double로 바꿔서 계산
		double avg = total / 3.0;
		
		System.out.println("합계: " + total);
		System.out.println("평균: " + avg);
		
		
	}

}
