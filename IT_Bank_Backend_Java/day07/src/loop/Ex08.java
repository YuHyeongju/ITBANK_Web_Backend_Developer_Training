package loop;

public class Ex08 {

	public static void main(String[] args) {
		// 단일 for문으로 1부터 9까지 출력하기
		for (int i = 1; i < 10; i++) {
			System.out.print(i + " ");
		}
		System.out.println();

		// 이중 for문 으로 1부터 9까지 출력하기
		for (int i = 1; i < 10; i += 3) {
			for (int j = i; j < i + 3; j++) {
				System.out.print(j + " ");
			}
		}
		System.out.println();

		// 시작값부터 마지막 값 까지 일정한 크기로 변화하면서 규칙성과 연속성이 필요
		for (int i = 1; i < 10; i++) {
			System.out.printf("%d x %d = %d\n", 3, i, 3 * i);
		}
		System.out.println();

		for (int dan = 2; dan < 10; dan++) {
			for (int i = 1; i < 10; i++) {
				System.out.printf("%d x %d = %d\n", dan, i, dan * i);
			}System.out.println();
		}System.out.println();
		
		
		

	}
}
