package string;

public class Quiz01 {

	public static void main(String[] args) {
		// 주어진 문자열에서 알파벳만 가져와서 새로 구성된 문자열 s2를 출력하세요.
		String str = "a1b2c3d4e5";
		String str2 = "";			//정수 덧셈에 대한 항등원이 0, 문자열 덧셈에 대한 항등원은 ""이다.(아무것도 더하지않은상태)
		
		

		for (int i = 0; i < str.length(); i++) {	//전체 글자 중에서
			char ch = str.charAt(i);				//str을 하나씩 잘라서 ch에 저장

			if (ch >= 48 && ch <= 57) { //숫자인 경우 아무것도 안함.
			// if(('a' <= ch && ch <= 'z') || ('A' <= ch && ch <='Z')){ //알파벳인 경우
			// str2 +=ch; } str2에 저장
				
			} else {					//알파벳인 경우
				str2 += ch;				//st2에 하나씩 저장
			}

		}
		System.out.println("str2 : " + str2);

	}

}
