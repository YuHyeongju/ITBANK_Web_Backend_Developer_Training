package string;

public class Ex03 {

	public static void main(String[] args) {
		// 주어진 문자열에서 알파벳만 가져와서 새로 구성된 문자열 s2를 출력하세요.
		String str = "a1b2c3d4e5";
		String filter = "adcdefgABCDEFG";
		String str2 = "";			
		
		

		for (int i = 0; i < str.length(); i++) {	// 전체글자 중
			char ch = str.charAt(i);				// 각 글자를 ch라 할때 
													// contains 함수에는 문자열을 전달해야한다.
			String s = ch + "";						// 필터가 글자를 포함하면(글자가 필터에 포함되면)
			if(filter.contains(s)) {				// 결과를 포함시킨다.
				str2 += s;
			}

		}
		System.out.println("str2 : " + str2);

	}
}
