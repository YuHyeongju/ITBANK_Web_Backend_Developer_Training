package abstraction;

abstract class  Loop{ 
	abstract void  loop(); // 추상메서드 (상속받는 서브클래스가 구현해야함.)
						
	void info() {		   // 일반 메서드( 오버라이딩이 강제 되지 않음, 구현 안해도됨)
		System.out.println("반복을 수행하는 클래스 입니다.");
	}
}

//정수를 반복해서 출력하는 클래스 NumberLoop + 다중실행이 가능한 특성이 부여됨.
class NumberLoop extends Loop implements Runnable{	
	@Override
	void loop() {
		for(int i = 0; i <= 10; i++ ){
			System.out.println(i + " ");
		}
		System.out.println();
	}

	@Override
	public void run() {
		loop(); 
		
	}
}

class AlphabetLoop extends Thread{ // 다중 실행 가능한 클래스 AlphabetLoop
	@Override
	public void run() {
		for(char ch = 'A'; ch <= 'Z'; ch++) {
			System.out.println(ch + " ");
		}
		System.out.println();
	}
}


public class Ex06 {

	public static void main(String[] args) {
		NumberLoop ob1 = new NumberLoop();
		AlphabetLoop ob2 = new AlphabetLoop(); // Thread: run() 대신 start()로 호출하면 다중 실행 가능
		
		Thread th = new Thread(ob1);		// Runnable 객체를 Thread생성자에 넣으면	
											// Thread 클래스의 객체와 동일하게 사용할 수 있다.
		
//		ob1.loop();	//loop를 끝내야 run이 실행된다. -> 순서가 강제된다.
//		ob2.run();
		
//		ob2.start();	// 다중실행 요소를 먼저 호출해두면 함수가 종료되지 않아도 다음 함수를 호출한다.
//		ob1.loop();		// ob1에서도 다중실행이 가능한 특성을 추가로 부여하고싶다.
						// Thread 클래스를 상속받으면 된다.
		            	// 자바에서는 클래스의 다중 상속을 허용하지않음. -> 인터페이스 사용(다중상속 허용)
		
												
		th.start();
		ob2.start();				
		
		
		
		// 인터페이스 특성
		// 1) 서로 다른 클래스(슈퍼클래스가 다르더라도)를 하나의 자료형으로 묶을 수 있다.
		// 2) 클래스 작성 시 추가적인 특성을 자유롭게 부여 할 수 있다.
		
		// 자주 사용하는 인터페이스 중에는 이름이 able로 끝나는 경우가 많다.
		// Runnalbe: 다중 실행 가능한.
		// Serializable: 데이터를 직렬화 할 수 있는(직렬화하면 파일 저장 및 네트워크 전송이 가능해짐)
		// cimparable: 배열 및 리스트 정렬 시 기준을 제시하지 않아도 기본값으로 정렬을 수행할 수 있다.
		
		// List set Map <- 인터페이스
		// 이 경우는 특성 부여보다, 서로 다른 여러 유형의 클래스를 같은 형식으로 묶기 위한 성격이 크다.
		// List를 구현하는 클래스: ArrayList, LinkedList, Stack, Queue, Vector...
	}

}
