package array;

import java.util.Arrays;
import java.util.Scanner;

public class Ex09 {

	public static void main(String[] args) {
		// 길이가 자동으로 증가하는 배열
		// 1) 자바의 배열은 같은 자료형만 담을 수 있으며, 생성 후에는 길이를 바꿀 수 없다.
		// 2) 하지만, 배열은 참조형이다.(레퍼런스 타입)
		// 3) 원본 배열보다 사이즈가 더 큰 배열을 생성한 다음, 원본 내용을 복사하여 바꿔치기 할 수 있다.
		// 4) 이 형식을 반복수행하면 길이가 자동으로 증가하는것과 같은 효과를 볼 수 있다.
		
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[3];	//최초 길이는 3
		int[] tmp;
		LOOP: while(true) {
			for(int i = 0; i < arr.length; i++) {
				if(arr[i] == 0) {
					System.out.print("정수 입력: ");
					arr[i] = sc.nextInt();
					if(arr[i] == 0) {			 // 0을 입력할 때 까지 반복해서 넣기
						break LOOP;
					}
				}
			}
			System.out.println(Arrays.toString(arr)); // 현재까지의 배열 출력
			tmp = new int[arr.length + 3];
			for(int i = 0; i < arr.length; i++) {
				tmp[i] = arr[i];
			}
			arr = tmp;  // arr가 tmp를 참조하게 만든다. 원래 있던 arr 배열은 jvm이 수거한다.
		}
	
	
	System.out.println(Arrays.toString(arr));
	System.out.println("끝");
	}
}
