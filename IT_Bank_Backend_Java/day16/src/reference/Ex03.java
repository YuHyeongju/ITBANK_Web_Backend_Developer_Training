package reference;

public class Ex03 {

	public static void main(String[] args) {
		// compareTo를 직접 구현해보기

		String s1 = "apple"; 	// [97, 112, 112, 108, 101]
		String s2 = "banana"; 	// [98, 97, 110, 97, 110, 97]
		String s3 = "aegis"; 	// [97, 101, 103, 105, 115]

		System.out.println("s1.compareTo(s2): " + s1.compareTo(s2));
		System.out.println("s1.compareTo(s3): " + s1.compareTo(s3));
		System.out.println("s2.compareTo(s3): " + s2.compareTo(s3));
		System.out.println();

		System.out.println("myCompareTo(s1, s2): " + myCompareTo(s1, s2));
		System.out.println("myCompareTo(s1, s3): " + myCompareTo(s1, s3));
		System.out.println("myCompareTo(s2, s3): " + myCompareTo(s2, s3));
		System.out.println();

	}

	static int myCompareTo(String s1, String s2) {
		int answer = 0;
		
		// 두 문자열의 길이가 다르다면 작은 길이만큼 반복해야한다.
		// ArrayIndexOfOutofBoundsException 발생

		int size = s1.length() > s2.length() ? s1.length() : s2.length();

		for (int i = 0; i < size; i++) {  // 정해진 길이만큼 반복하면서
			char a = s1.charAt(i);		  // s1의 i번째 글자(문자열 상태에서는 비교불가) 
			char b = s2.charAt(i);		  // s2의 i번째 글자(문자열 상태에서는 비교불가) 
			if (a != b) {				  // 두 글자가 서로 다르다면 
				answer = a - b;			  // 두 글자의 차이를 저장한다.
				break;					  // 차이를 찾았다면 반복 중단
			}

		}
		// 반복문이 끝났음에도 차이를 발견하지 못했고 문자열의 길이가 다르다면
		if (s1.length() != s2.length()) {
			answer = s1.length() - s2.length();	// 길이의 차이를 저장
		}

		return answer; 							// 정답 반환
	}

}
