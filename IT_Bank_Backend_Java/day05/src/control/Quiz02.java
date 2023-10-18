package control;

import java.util.Scanner;

public class Quiz02 {

	public static void main(String[] args) {
		/*
		 * 놀이공원에 있는 놀이기구에 대한 이용 요금을 계산해야한다. 이 놀이기구는 탑승하면 기본 3000원의 요금을 받고 이용 시간에 따라 추가
		 * 요금이 발생한다. 그 시간과 요금은 아래와같다.
		 * 
		 * 시간 요금 0 ~ 30 3000 31 ~ 40 3500 41 ~ 50 4000
		 * 
		 * 시간을 분으로 입력 받아서, 요금을 출력하는 프로그램을 작성하세요.
		 * 
		 */
		int basicPrice = 3000;
		int time;
		int addTime;
		int totalPrice;
		

		Scanner sc = new Scanner(System.in);

		System.out.println("이용 시간 (분) 입력: ");

		time = sc.nextInt();

		addTime = (time - 30) / 10 + 1; // 1
		
		if ((time - 30) % 10 == 0) { //나누어 떨어질 때는 addTime에서 1을 뺸다. 
			addTime -= 1;
		}

		totalPrice = addTime * 500 + basicPrice; //총 가격 = 추가시간 * 500 + 기본 가격

		if (time <= 30) {
			System.out.println("요금: " + basicPrice);
		} else {

			System.out.println("요금 : " + totalPrice);

		} 
		sc.close();
		/*
		강사님 코드
		
		if(time > 30) {
			addTime = ((time -30) /10 ) * 500;
			if(time % 10 != 0){
				addTime += 500;
			}
			totalPrice += addtime;
		
		}*/
	
	}
}
