package p2;

import java.util.Scanner;

public class Toy {
	
	private Battery battery;
	private String text;
	private Scanner sc;
	
	public Toy(Battery battery) {
		this.battery = battery;
		text= 	"송아-지 송아-지\n" + 
				"얼룩 송아지\n" + 
				"엄마 소도 얼룩소\n" + 
				"엄마- 닮았네\n" + 
				"\n" + 
				"송아-지 송아-지\n" + 
				"얼룩 송아지\n" + 
				"두- 귀가 얼룩귀\n" + 
				"귀가- 닮았네";
		sc = new Scanner(text);
	}
	
	public void run() {
		if(sc.hasNextLine() == false){
		sc = new Scanner(text);
		
		}
		else if(sc.hasNextLine() && battery.getEnergy() > 10) {
			String line = sc.nextLine();
			System.out.println(line);
			battery.useEnergy();
		}else {
			System.err.println("에너지가 없습니다.");
		}
	}
}
