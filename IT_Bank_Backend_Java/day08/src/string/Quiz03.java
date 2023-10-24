package string;


public class Quiz03 {

	public static void main(String[] args) {
		/*
		 * 16자리 카드번호로 문자열을 입력받아서 카드번호의 오른쪽 끝부터 세어서 
		 * 홀수 번째는 그대로 두고 짝수번쨰는 2를 곱한다. 
		 * 만약 2를 곱한 숫자가 두자리수면 각 자리수를 더해서 한자리 수를 만든다. 
		 * 이렇게 만들어진 16개의 한자리 숫자를 모두 더하여 그 합이 10으로 나누어
		 * 떨어지면 유효한 카드번호 아니면 유효하지 않은 카드번호(luhn 알고리즘)
		 * 카드번호를 입력받아서 유효성을 검증하는 코드를 작성하시오
		 */
		String input = "1234-2134-1234-1234";
		input = input.replace("-", "");
		String s = "";
		int num = 0;
		for (int i = 0; i <= 15; i--) {
			char ch = input.charAt(i);

			if (i % 2 == 0) {
				num = ((char) (ch - 48) * 2);
				
			} else {
				s += ch;
			}
			
		}

	}

}
