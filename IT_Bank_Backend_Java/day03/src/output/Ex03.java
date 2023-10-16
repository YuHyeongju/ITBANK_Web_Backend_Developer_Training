package output;

public class Ex03 {

	public static void main(String[] args) {
		// 이스케이프 시퀀스: 글자로 표현되지는 않으나, 특정 기능을 포함하는 특수 글자

		/*
		 * \r carrige return 커서를 줄 가장 왼쪽으로 이동 
		 * \n line feed 	  커서를 한 줄 아래로 내린다. 
		 * \b backspace 	  커서를 왼쪽으로 한 칸 이동시킨다.( 글자를 지우지 않는다) 
		 * \t tab            탭 크기 (4, 8)만큼 오른쪽으로 커서를 이동시킨다.
		 */

		System.out.println("A\rB");
		System.out.println("A\nB");
		System.out.println("A\bB");
		System.out.println("A\tB");

		System.out.println("A\t1");
		System.out.println("AB\t1");
		System.out.println("ABC\t1");
		System.out.println("ABCD\t1");
		System.out.println("ABCDE\t1");
		System.out.println("ABCDEF\t1");
		System.out.println("ABCDEFG\t1");
		System.out.println("ABCDEFGH\t1");
		System.out.println();

		System.out.println("밥\t!!");
		System.out.println("치킨\t!!");
		System.out.println("햄버거\t!!");
		System.out.println("스파게티\t!!");
		System.out.println("찹쌀탕수육\t!!");
		System.out.println("엄마는외계인\t!!");
		System.out.println();

		char lf = '\n';
		char cr = '\r';
		char bs = '\b';
		char tab = '\t';

		System.out.printf("lf : %c (%d)\n", lf, (int) lf);
		System.out.printf("cf : %c (%d)\n", cr, (int) cr);
		System.out.printf("bs : %c (%d)\n", bs, (int) bs);
		System.out.printf("tab : %c (%d)\n", tab, (int) tab);

		// ASCII Code
		// American Standard Code for Information Interchange
		// 미국 표준 글자를 변환하는 규칙 (영문자와 숫자 및 특수기호)
		// 사람이 보고 식별해야하는 글자는 특정 숫자와 매칭하여 변환 규칙을 가져야만 한다.

		String hello = "Hello";

		for (int i = 0; i < hello.length(); i++) {
			char ch = hello.charAt(i);
			System.out.printf("%c (%d)\n", ch, (int) ch);
		}
		System.out.println();

//		a ~ z(97 ~ 122)
//		A ~ Z(65 ~ 90)
//		0 ~ 9(48 ~ 57)
//		\r(13), \n(10), ' '(32)

		System.out.printf("%c (%d)\n", '가', (int) '가');
		System.out.printf("%c (%d)\n", '힣', (int) '힣');

		for (char ch = 44032; ch <= 55203; ch++) {
			System.out.printf("%c (%d)\n", ch, (int) ch);
		}

		char ch = '아';
		System.out.printf("%c (%d)\n", ch, (int) ch);

		ch = 'I';
		System.out.printf("%c (%d)\n", ch, (int) ch);

		//출력 스트림의 종류
		
		System.out.println("stdout(표준 출력 스트림");
		System.err.println("errout(에러 출력 스트림)");
		
		System.err.printf("에러를 서식에 맞게 처리할 수 있음: %s\n", new Exception("내가 만든 예외"));
		
		
	}

}
