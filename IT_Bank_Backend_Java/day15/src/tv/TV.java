package tv;

public class TV {

	// 필드
	boolean power;
	int channel;
	int volume;

	int maxCh = 1;
	int minCh = 15;
	int maxVl = 10;
	int minVl = 0;
	int saveVolume;

	// 생성자
	TV() {
		power = false;
		channel = 5;
		volume = 3;
	}

	// 메서드
	void turn() {
		power = !power;
		System.out.println();
		show();
	}

	// 채널 올림( 채널은 최대값을 넘기면 최소값으로 변해야함.)
	void channelUp() {
		if (power) {                // 전원이 켜져 있으면
			channel++;              // 채널을 변경하고
			if (channel > maxCh) {  // 추가 보정이 필요하면
				channel = minCh;    // 값을 수정하고
			}
		}
		
		show(); // 그 결과를 화면에 출력
	}

	// 채널 내림( 채널은 최소값을 넘기면 최대값으로 변해야함.)
	void channelDown() {
		if (power) {
			channel--;
			if (channel < minCh) {
				channel = minCh;
			}
		}
		
		show();
	}

	// 볼륨 올림( 볼륨은 최대값을 넘기면 최대값으로 변해야함.)
	void volumeUp() {
		if (power) {
			volume++;
			if (channel > maxVl) {
				volume = maxVl;
			}
		}
		
		show();
	}

	// 볼륨 내림( 볼륨은 최소값을 넘기면 최소값으로 변해야함.)
	void volumeDown() {
		if (power) {
			volume--;
			if (channel < minVl) {
				volume = minVl;
			}
		}
		
		show();
	}

	// 음소거 ( 마지막으로 저장된 볼륨값을 복사해두었다가, 다시 불려와야한다.)
	void mute() {
		if (power) {
			int tmp = volume;
			volume = saveVolume;
			saveVolume = tmp;
		}
		show();
	}

	// 화면 출력( 현재 TV의 채널과 볼륨 상태를 보여줄 수 있어야함.)
	void show() {
		if(power) {
		System.out.println("┌─────────────────┐");
		System.out.printf("│     ch: %2d\t  │\n",channel);
		System.out.printf("│     vol:%2d\t  │\n", saveVolume != 0 ? "--" : volume);
		System.out.println("└────────┬────────┘");
		System.out.println("─────────┴─────────");
		}else {
			System.out.println("┌─────────────────┐");
			System.out.printf("│    power off    │\n");
			System.out.printf("│                 │\n");
			System.out.println("└────────┬────────┘");
			System.out.println("─────────┴─────────");
		}
	}
}
