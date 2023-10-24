package day09;

class Solution {
	public boolean solution(String cardNumber) {
		// 0) 최초 문제풀이에는 1개의 값을 처리하는 코드를 작성한다.
		
		// 1) 카드번호 - 가 포함되어 있다면 제거
		String s1 = cardNumber.replace("-", "");
		int sum = 0; // 합계 저장 변수

		// 2) 문자열에서 각 자리의 글자를 계산할 수 있는 숫자로 추출해야함.
		for (int i = 0; i < s1.length(); i++) {
			char ch = s1.charAt(i); // char
			int num = ch - 48; // int
			// int num = Character.getNumericValue(ch); 			wrapper 클래스
			// int num = Integer.parseInt(s1.substring(i , i + 1)); //한글자 뽑아옴

			// 3) 왼쪽부터 index를 기준으로 세어서 짝수는 2배, 홀수는 그대로 둔다.
			if (i % 2 == 0) {
				num *= 2;
			}
			// 4) 만약 2배 한 값이 두자리수(=10이상), 각 자리수를 합친다.
			if (num >= 10) {
				num = (num / 10) + (num % 10);
			}
			// 5) 16개의 숫자의 합계를 구할 변수가 준비되어있어야함.
			sum += num;
		}

		return sum % 10 == 0;
	}
}

public class Luhn_fuction {

	public static void main(String[] args) {
		String input = "1162-3434-1010-2111";	// 유효함
		String input2 = "1162-3434-1010-2113";	// 유효함
		
		// 6) 검증이 끝나면 함수 형태로 변경하여 여러 값을 처리할 수 있도록 한다.
		
		Solution s = new Solution();
		System.out.println("input이 유효한가: " + s.solution(input));
		System.out.println("input이 유효한가: " + s.solution(input2));
	}

}
		//method : 일정한 문제 처리 방식 




