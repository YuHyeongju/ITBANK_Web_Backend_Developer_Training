package string;

import java.util.Scanner;

public class Ex02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s1 = "Hello";
		String s2 = "Hello";
		String s3;

		System.out.println("Hello 라고 입력하세요: ");
		s3 = sc.next();

		System.out.println("s1 == s2 : " + (s1 == s2));
		System.out.println("s2 == s3 : " + (s2 == s3));
		System.out.println("s1 == s3 : " + (s1 == s3));

		System.out.println();

		// 문자열은 equals로 비교한다.
		System.out.println("s1.equals(s2) : " + (s1.equals(s2)));
		System.out.println("s1.equals(s3) : " + (s1.equals(s3)));
		System.out.println("s1.equals(s3) : " + (s1.equals(s3)));
		System.out.println();

		// 문자열의 내용 비교
		// 1) A.equals(B) : A와 B의 내용이 정확히 일치하는가
		// 2) A.startWith(B) : A문자열이 B내용으로 시작하는가 (접두사 체크)
		// 3) A.endsWith(B) : A문자열이 B문자열로 끝나는가 (접미사 체크)
		// 4) A.contains(B) : A문자열이 B내용을 포함하는가 (검색어 포함)
		
		System.out.println("s1.startWith(\"He\") : " + (s1.startsWith("He")) );
		System.out.println("s1.startWith(\"lo\") : " + (s1.endsWith("lo")) );
		System.out.println("s1.startWith(\"el\") : " + (s1.contains("el")) );

		sc.close();
	}

}
