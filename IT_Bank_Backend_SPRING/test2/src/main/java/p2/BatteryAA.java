package p2;

public class BatteryAA implements Battery {
	private int energy; // alt shift S + R

	public int getEnergy() {
		return energy;
	}

	public void setEnergy(int energy) {// <property> 속성
		this.energy = energy;
	}

	public BatteryAA(int energy) { // <constructor-arg> 생성자 매개변수
		this.energy = energy;
	}

	public BatteryAA() { // toy-context.xml에서 property태그로 객체를 생성하기 위해
					     // 만든 기본 생성자

	}
	public void useEnergy() { //Toy클래스에서 run을 할때마다 useEnergy를 호출해야함.
		this.energy -= 10;
	}
}
