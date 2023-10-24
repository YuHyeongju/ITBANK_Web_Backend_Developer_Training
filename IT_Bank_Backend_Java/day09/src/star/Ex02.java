package star;

public class Ex02 {

	public static void main(String[] args) {
		// 횟수를 제어할 변수를 미리 만들어 두고 내가 직접 횟수를 변경/제어하기

		int size = 5;
		int sp = 2; // 공백의 개수 sp = size / 2
		int st = 1; // 별의 개수

		for (int i = 0; i < size; i++) {
			// 공백
			for (int j = 0; j < sp; j++) {
				System.out.print("  ");
			}
			// 별
			for (int j = 0; j < st; j++) {
				System.out.print("* ");
			}
			// 공백
			for (int j = 0; j < sp; j++) {
				System.out.print("  ");

			}
			System.out.println(); // 한줄 끝나면 줄 변경

			if (i < size / 2) { // 전체 줄 중에서 가운데 도달하지 못하면 (윗부분)
				sp -= 1;
				st += 2;
			} else { // 가운데를 줄이거나 아랫쪽이면
				sp += 1;
				st -= 2;

			}
		}

	}

}

/*
    *     
  * * *   
* * * * * 
  * * *   
    *   
*/

