package accessModifier;

class Message {

	private String name;
	// 같은 클래스를 사용하는 서로 다른 객체라면 
	// private이더라도 필드 값에 직접 접근이 가능함.
	
	
	public Message(String name) {
		this.name = name;
	}

	void sendMessage(Message other, String message) { 
		// 받는사람의 receive 메시지를 호출한다.
		// 이때 전달하는 this는 sendMessage를 호출했던 자기자신이다.
		// 따라서 this의 자료형은 Message이다.
		other.receieveMessage(this, message);			// A라는 사람이 B라는 사람에게 
														// 문자열 형태의 데이터를 보냄
	}

	void receieveMessage(Message sender, String message) {
		System.out.printf("=== %s의 화면 ===\n",this.name);
		System.out.printf("%s : %s\n", sender.name, message);
		// sender를 호출하면 고유번호를 출력한다.
	}

}

public class Ex02 {

	public static void main(String[] args) {
		Message ob1 = new Message("짱구");
		Message ob2 = new Message("유리");
		
		ob1.sendMessage(ob2, "유리야 안녕");					//ob1 = this, ob2 = other, message = message
		ob2.sendMessage(ob1, "안녕 짱구야, 소꿉놀이 하러 갈래?");
	}

}
