package function;

// 주어진 배열에서 가장 빈도가 많은 값을 구하세요.
// 가장 많이 등장한 값의 횟수가 아니라, 값 그 자체를 반환해야한다.
// 최빈값이 2개이상이면 -1 반환

// 0 < array의 길이 < 100
// 0 < array의 원소 < 1000

class Solution {
	public int solution(int[] array) {
		int answer = 0;
		int max = 0;

		// 원소의 최대값을 먼저 구하고, 그 길이만큼 배열을 생성하여 횟수 체크에 사용
		// 이 과정을 생략하고 싶다면 길이 1001의 배열 생성
		// +1이 들어가는 이유는 0부터 시작하는 index의 특성상 계산이 번거로워져서
		// {0,0,0,0,0,...0,0}

		for (int i = 0; i < array.length; i++) { //최대값 구하기

			if (max < array[i]) {
				max = array[i];
			}
		}
		int[] counts = new int[max + 1];
		
		for(int i = 0; i < array.length; i++ ) {
			int num = array[i];
			counts[num] += 1;
		}
		
		max = 0;
		for(int i = 0; i < counts.length; i++) {
			int num = counts[i];
			if( max < num) {
				max = num;		// 가장 높은 등장 빈도수 찾기
				answer = i;		// 최대값을 찾았을때 그 위치(index)도 answer에 저장한다.
			}
		
		}
		System.out.println("max : " + max);
		System.out.println("answer : " + answer);
		
		//최대값이 1개이면 answer에 담고 2개이상이면 -1담기
		
		
		
		// 최빈값을 answer에 담아서 반환
		// array에서 가장 많이 등장한 값을 찾아야 한다.
		// arrry의 각 값이 등장한 횟수를 체크한다.
		// 횟수에서 최대값을 찾아서, 횟수가아닌 가장 많이 등장한 값을 answer에 담는다.
		// 만약, 횟수에서 최대값이 중복되면 , answer에 -1을 담는다.
		
		int dup = 0; 								// 중복 체크 변수
		for(int i = 0; i < counts.length; i++) {	// counts에서 최대값이 총 몇개인지 확인
			if(counts[i] == max) { // 최대값이 일치할때 
				dup++;			   // 증가
			}
		
		}
		System.out.println("dup: " + dup);
		System.out.println("===================================");
		
		if(dup > 1) {		// 최대값이 1 초과 -> (2개이상) 
			answer = -1;	// 최빈값이 유일하지 않음으로, -1을 대입하여 반환
		}
		
		
		
		return answer;
	}
}

public class Pro120812 {
	public static void main(String[] args) {
		Solution s = new Solution();
		int answer1 = s.solution(new int[] { 1, 2, 3, 3, 3, 3, 4 });
		int answer2 = s.solution(new int[] { 1, 1, 2, 2 });
		int answer3 = s.solution(new int[] { 1 });
		System.out.println(answer1); 
		System.out.println(answer2); 
		System.out.println(answer3);

	}

}
