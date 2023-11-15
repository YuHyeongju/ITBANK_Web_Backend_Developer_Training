package functionalInterface;

interface Test {
	void method(String s); // 함수형 인터페이스
							// 인터페이스 중에서 추상메서드가 오직 하나만 있는 형식

}

class Repository {
	String[] arr = new String[] { "이지은", "홍진호", "짱구", "단비", "김태리", "유진초이" };

	public void forEach(Test lambda) { 		   // 메서드에 내용이 구현되있지 않기때문에
		for (int i = 0; i < arr.length; i++) { // 인자로 람다를 전달해야한다.
			if (arr[i] != null) { 			   // 이 람다를 즉석해서 익명클래스로 구현해야한다.
				lambda.method(arr[i]);
			}
		}
	}
}

public class Ex01 {

	public static void main(String[] args) {
		Repository repo = new Repository();

		repo.forEach(str -> System.out.println(str));
		System.out.println();

		repo.forEach(str -> System.out.println(str.length()));
		System.out.println();

		Test lambda = (str) -> {
			String odd = "홀수";
			if (str.length() % 2 == 0) {
				odd = "짝수";
			}
			System.out.println();
		};
		repo.forEach(lambda);

	}

}
