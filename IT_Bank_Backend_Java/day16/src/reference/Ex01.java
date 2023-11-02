package reference;

// 객체의 참조

class Test01 { // 정수를 객체 형태로 저장하기 위한 클래스
	//private int num;
	int num;

	Test01(int num) {
		this.num = num;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
}

public class Ex01 {
	static void swapInt(int n1, int n2) {
		int tmp = n1;
		n1 = n2;
		n2 = tmp;
	}

	static void swapObject(Test01 n3, Test01 n4) {
//		int tmp = n3.getNum(); // tmp = n3; // num 이 private인 경우
//		n3.setNum(n4.getNum()); // n3 = n4;
//		n4.setNum(tmp); // n4 = tmp;
		
		int tmp = n3.num;					// num이 private이 아닌 경우
		n3.num = n4.num;
		n4.num = tmp;
	}

	public static void main(String[] args) {
		int n1 = 10, n2 = 20;
		System.out.printf("n1 : %d, n2 : %d\n", n1, n2);
		swapInt(n1, n2);
		System.out.printf("n1 : %d, n2 : %d\n", n1, n2);
		System.out.println();

		Test01 n3 = new Test01(30);
		Test01 n4 = new Test01(40);
		System.out.printf("n3 : %d, n4 : %d\n", n3.getNum(), n4.getNum());
		swapObject(n3, n4);
		System.out.printf("n3 : %d, n4 : %d\n", n3.getNum(), n4.getNum());
		System.out.println();

	}

}
