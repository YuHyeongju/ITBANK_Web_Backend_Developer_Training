package string;

public class Ex05 {

	public static void main(String[] args) {
		// 찾아 바꾸기, replace
		// A.replace(B,C)
		// A 문자열에서 b를 찾아서 c로 바꾼 다음 내용을 반환

		
		String s1 = "아버지 가방에 들어가신다.";
		String s2 = s1.replace("지 가", "지가 ");
		String s3 = s2.replace("아버지" , "어머니");
		
		System.out.println(s1); // 원본은 그대로 보존된다.
		System.out.println(s2);	// 변경된 내용의 새로운 문자열이 만들어진다.
		System.out.println(s3);
		
		System.out.println();
		
		String s4 = ".........";
		String s5 = s4.replace("...", ".."); 			//한 문장에 일치하는 패턴 여러개를 동시에 바꾼다.
		System.out.println("s4: " + s4);
		System.out.println("s5: " + s5);
		System.out.println();
		
		
		String s6 = "가지가지해";
		String s7 = s6.replace("가지",  "🍆"); 			//win + .
		String s8 = s7.replace("해", "🌞");
		System.out.println("s6 : " +s6);
		System.out.println("s7 : " +s7);
		System.out.println("s8 :" + s8);
		System.out.println();
		
		String s9 = "a.....b..cde.......f";
		String s10 = s9.replace("..", ".");
		System.out.println("s9 : " + s9);
		System.out.println("s10 : " + s10);
		
		String s11 = s9;
		while(s11.contains("..")) {						// s11이 .을 포함하는 동안 계속 반복
			System.out.println("s11 : " + s11);
			s11 = s11.replace("..", ".");				// ..을 .으로 바꾼다.(연속된 .이 없도록)
		}
		System.out.println("s11 : " + s11 );			// 연속된 점을 없애고 싶을때 이 방법을 사용
		System.out.println();
		
		String s12 = "Hello, Java. \r\nJava is easy!!";
		String s13 = s12.replaceFirst("Java", "world");	// 첫번째 패턴만 바꾸기
		System.out.println("s12 : " + s12);
		System.out.println("s13 : " + s13);
		
		
	}
		
		

}
