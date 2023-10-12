package variable;

public class Quiz01 {

	public static void main(String[] args) {
		double height = 172.8;
		double weight = 67.4;
		
		//위 두 변수에 저장된 값을 활용하여 키와 체중을 소수점 아래자리 없이 정수 형태로 출력
		//자료형 변환을 활용하여 새로운 변수에 저장하고 값을 출력
		
		int height1 = (int)height;
		int weight1 = (int)weight;
		
		System.out.println("몸무게: " + height1);
		System.out.println("키: " + weight1);

		//실수는 소수점까지 표현되지만, 정수는 소수점을 표현하지않음.
		//실수 값을 정수형 변수에 옮겨 담으면 소수점은 잘린다.
		
		
	}

}
