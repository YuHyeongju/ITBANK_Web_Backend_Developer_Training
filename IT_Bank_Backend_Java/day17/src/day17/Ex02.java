package day17;

class Test02{
	int x;
	int y;
	
	void showAdd() {
		System.out.printf("%d + %d = %d\n",x,y);
	}
}

// this.[멤버]		멤버 필드 및 멤버 메서드에 접근한다.
// this()      		클래스 생성자 내부에서 또 다른 생성자를 호출할 때 사용한다. 첫 줄만 사용 가능.
// this     		객체 자기 자신을 표현하거나, 참조변수형식으로 전달하기 위해 사용함. 

public class Ex02 {

	public static void main(String[] args) {
		Test02 ob = new Test02(); // 1) Test02클래스의 내용을 읽어서 객체를 생성하고, ob변수가 가리키게 한다.
		
		ob.x = 10; // 2) ob객체의 x필드에 10을 대입한다.
		ob.y = 20; // 3) ob객체의 y필드에 20을 대입한다.
		
		ob.showAdd();	// 7) ob객체의 showAdd메서드를 호출한다.
		
		System.out.println("프로그램 종료");
		// 8) 메인함수 종료

		// 특정함수 내부로 진입하기 위해서 ctrl + 클릭
		// 이동한 곳에서 다시 이전 위치로 이동하기위해서 alt + ←
	}

}
