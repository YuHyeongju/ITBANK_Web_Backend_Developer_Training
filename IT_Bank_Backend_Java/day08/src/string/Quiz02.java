package string;
// 문제
// 1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
// 2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
// 3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
// 4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
// 5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
// 6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
//     만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
// 7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.

class Solution {
	public String solution(String new_id) {
		String answer = "";

		new_id = new_id.toLowerCase(); // 1단계

		for (int i = 0; i < new_id.length(); i++) { // 2단계
			char ch = new_id.charAt(i);

			if ('a' <= ch && ch <= 'z') {
				answer += ch;
			}
			if ('0' <= ch && ch <= '9') {
				answer += ch;
			}
			if (ch == '-' || ch == '_' || ch == '.') {
				answer += ch;
			}
		}

		while (answer.contains("..")) {
			answer = answer.replace("..", "."); // 3단계
		}

		if (answer.startsWith(".")) {
			answer = answer.substring(1); // 4단계
		}								  // 1번째 인덱스부터 끝까지 잘라서 다시 저장한다.

		if (answer.endsWith(".")) {
			answer = answer.substring(0, answer.length() - 1); //마지막 인덱스를 포함하지 않음으로 -1
		}

		if (answer.equals("")) { // 5단계		빈 문자열 -> a대입
			answer += 'a';		 // 리터럴과 변수의 비교 리터럴을 앞에 세우는게 좋음
		}						 // .연산자 앞에 null이 오면 안되기 때문에

		if (answer.length() >= 16) { // 6단계
			answer = answer.substring(0, 15);	//16글자 이상이면 0 ~ 15글자 빼고 자름.
		}

		if (answer.endsWith(".")) {
			answer = answer.substring(0, answer.length() - 1);
		}

//		if (answer.length() <= 2) { // 7단계
//			while (answer.length() != 3) {
//				answer += answer.charAt(answer.length() - 1);
//			}
//		}
		while (answer.length() <= 2) {
			answer += answer.charAt(answer.length() - 1);
		}

		return answer;
	}
	public static void main(String[] args) {
		
	}
}