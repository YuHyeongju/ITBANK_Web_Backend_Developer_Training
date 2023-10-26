package function;

import java.util.Random;
import java.util.Scanner;

public class Ex03 {

	public static void main(String[] args) {
		// rpg 게임의 아이템 강화 시뮬레이션

		// 아이템 강화할때 마다 무기의 레벨이 올라감.
		// 아이템을 강화하는데 일정량의 게임머니가 소비된다.
		// 게임머니는 한정되어있다.
		// 아이템의 레벨이 일정값을 넘어가면 강화 확률이 감소한다.
		// 레벨1 ~ 레벨5까지는 100프로
		// 레벨6 : 90%
		// 레벨7 : 80%
		// 만약 강화에 실패하면 게임머니는 그대로 소비, 아이템 레벨은 하락
		// 한정된 게임머니로 누가 제일 높은 레벨까지 도달하는지 겨루는 게임이다.
		// 게임머니를 모두 소비하거나, 스스로 중단 가능

		Scanner sc = new Scanner(System.in);
		int money = 10000;
		int fee = 500;
		int lv = 1;
		int menu;
		boolean flag;

		LOOP: while (true) {  //라벨 이름을 걸어놓고 밑에서 break 라벨 이름을 쓰면 이 while문을 탈출함.
			System.out.println("==============================");
			System.out.println("현재 레벨 : " + lv);
			System.out.printf("현재 머니: %d원\n", money);
			System.out.println("1. 강화");
			System.out.println("0. 포기");
			System.out.print("메뉴 선택 >>>> ");
			menu = sc.nextInt();

			switch (menu) {
			case 1:
				if (money < fee) {
					System.out.println("머니가 부족합니다.");
					break LOOP;
				}
				
				flag = enhance(lv);  // 강화시도 -> 결과 반환 (현재 아이템 레벨에 따라 성공 확률이 달라짐)
				money -= fee;        // 강화비용 받기
				lv += flag ? 1 : -1; // 성공하면 1이 더해지고, 실패하면 -1이 더해짐.
				break;
			case 0:
				break LOOP; 		//LOOP라는 이름의 while문을 탈출함.
			}
			//end of while: 이 안에 있는 내용만 반복 실행
		}
		System.out.println();
		System.out.println("최종 결과");
		System.out.println("현재 레벨 : " + lv);
		System.out.printf("현재 머니: %d원\n", money);
		System.out.println("점수: " + (lv * 1000 + money));
		
		sc.close();
	}//end of main
	
	static boolean enhance(int lv) {
		boolean success = true;
		Random ran = new Random();
		int R = ran.nextInt(100) + 1; //0은 안됨

		int suc = 100 - (lv - 4) * 10;
		

		if(lv < 5) {
			System.out.println("강화성공!!");
		}
		
		if(lv >= 5) {
			if(suc >= R) {			// 성공
				success = true;
				System.out.println("강화성공!! ");
			}else {
				success = false;	// 실패
				System.out.println("강화실패!! 헤헷 손이 미끄러졌네");
			}
			for (int i = 0; i < 3; i++) {
				System.out.print(".");
				try {
					Thread.sleep(500);
				} catch (Exception e) {
				};
			}
			System.out.println();
		}
		System.out.printf("%d / %d (%s)\n",R,suc, R <=suc);
		//%s는 true, false (강화 성공/실패) 보여줌
		return success;
	}
	//end of class: main() 혹은 다른 함수들은 모두 class 내부에 있어야함. 
} 
