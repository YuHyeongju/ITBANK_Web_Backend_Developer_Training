package oop;

import java.util.Scanner;

class TV {
	// TV의 속성을 필드로 작성하세요
	// 전원, 채널, 볼륨
	boolean power;
	int channel;
	int volume;
	int muteVolume;

	// TV의 기능을 메서드로 정의하세요.
	void powerTurn() {
		power = !power;
		show();
	}

	void channelUp() {
		if (power == true) {
			channel += 1;
			if (channel > 6) {
				channel = 1;
			}
		}
		show();
	}

	void channelDown() {
		if (power == true) {
			channel -= 1;
			if (channel < 1) {
				channel = 6;
			}
		}
		show();
	}

	void volumeUp() {
		if (power == true) {
			volume += 1;
			if (volume > 10) {
				volume = 10;
			}
		}
		show();
	}

	void volumeDown() {
		if (power == true) {
			volume -= 1;
			if (volume < 1) {
				volume = 1;
			}
		}
		show();
	}

	void muteVolume() {
		if (power == true) {
			int tmp = volume;
			volume = muteVolume;
			muteVolume = tmp;
		}
		show();
	}

	void show() {
		if (power) {
			System.out.println("전원이 켜져있습니다.");
			System.out.println("┌─────────────────────────┐");
			System.out.println("│                         │");
			System.out.printf("│	  채널: %02d\t  │\n", channel);
			System.out.printf("│	  볼륨: %02d\t  │\n", volume);
			System.out.println("│                         │");
			System.out.println("└─────────────────────────┘");
		} else {
			System.out.println("┌─────────────────────┐");
			System.out.println("│                     │");
			System.out.println("│                     │");
			System.out.println("│     power off	      │");
			System.out.println("│                     │");
			System.out.println("│                     │");
			System.out.println("└─────────────────────┘");
		}
	}

	// 전원 on/off, 채널올림/내림, 볼륨올림/내림 , tv상태 출력, 음소거
	// 채널은 일정 범위 안에서 cycle 형식으로 순환되어야한다.
	// 볼륨은 일정 범위 안에서 최소 최대치를 넘길 수 없다.
	// 음소거는 한 번 누르면 볼륨이 0이되었다가 다시 누르면 원래 볼륨으로 복구되어야한다.
	// 대부분의 기능은 전원이 켜져있는 상태에서만 사용가능

	// 생성자에서 객체 생성시 초기값을 지정
	// 매개변수로 받지 않아도 초기값을 지정할 수 없다.
	// 예를 들면 채널의 초기값이 0인 것은 이상합니다. 다른 값이 초기값이 되도록 해야함.
	TV(){
		this.channel = 1;
		this.volume = 1;
		this.muteVolume = 0;
	}
}

public class Quiz03 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		TV tv = new TV();
		int menu;

		LOOP: while (true) {
			System.out.println("기능");
			System.out.println("1):tv 켜기/끄기, 2):채널 올리기, 3):채널 내리기, 4):볼륨 올리기, 5):볼륨 내리기");
			System.out.println();
			System.out.println("6): 음소거/해제, 0): 프로그램종료");
			System.out.println();
			System.out.print("tv에게 일을 시켜보자: ");
			menu = sc.nextInt();
			switch (menu) {
			// 입력된 메뉴에 따라서 tv객체의 메서드를 호출하는 형태로 진행
			case 1:
				tv.powerTurn();
				break;
			case 2:
				tv.channelUp();
				break;
			case 3:
				tv.channelDown();
				break;
			case 4:
				tv.volumeUp();
				break;
			case 5:
				tv.volumeDown();
				break;
			case 6:
				tv.muteVolume();
				break;
			case 0:
				break LOOP;
			}
		}
		sc.close();
		System.out.println("프로그램 종료");
	}

}
