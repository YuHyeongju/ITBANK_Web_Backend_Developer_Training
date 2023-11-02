package accessModifier;

// 아래 두 클래스는 같은 패키지에 있으므로, default(package) 접근제한자가 기본 적용됨.


class Test01{
	private int n1 = 10;	// n1을 참조하는 코드가 클래스 안에 없다.
	int n2 = 20;			// 같은 패키지 내부이므로, Ex01에서는 Test01의 n2에 접근불가	
	protected int n3 = 30;	// 다른 패키지에 있는 상속관계 클래스 간의 접근 허용
	public int n4 = 40;
	
	public int getN1() {	// private 필드라도, 클래스 내부에서는 자유롭게 접근 가능함.
		return n1;
	}
	
	// getter의 필요성이 가장 큰 접근제한자는 private이다.
	
}



public class Ex01 {
	public static void main(String[] args) {
		
		Test01 ob = new Test01();
		//System.out.println("ob.n1: " + ob.n1);
		System.out.println("ob.n1: " + ob.getN1()); 
		System.out.println("ob.n1: " + ob.n2);
		System.out.println("ob.n1: " + ob.n3);
		System.out.println("ob.n1: " + ob.n4);
	} 
	
}
