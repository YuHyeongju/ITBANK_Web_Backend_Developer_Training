package loop;

import java.util.Scanner;

public class Ex04 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String arrow = "↑";
		int distance;
		
		System.out.print("0 ~ 30 입력 : ");
		distance = sc.nextInt();
		
		System.out.println("┌────┬────┬────┬────┬────┬────┐");
		System.out.println("│││││││││││││││││││││││││││││││");
		System.out.println("0    5    10   15   20   25   30");

		for(int i  = 0; i < distance; i++) {
			System.out.print(" ");				
		}
		System.out.print(arrow);
	}
	//입력받은 숫자 만큼 공백문자 출력을 반복하여 이동하여 반복문이 끝나는 시점에 ↑를 찍어줌.

}
