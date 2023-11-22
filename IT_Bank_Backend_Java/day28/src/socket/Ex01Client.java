package socket;


import java.net.Socket;
import java.util.Scanner;

public class Ex01Client {

	public static void main(String[] args) throws Exception {
		// 아이피와 포트번호를 지정하여 대상 서버에 접속한다.
		Socket so  = new Socket("127.0.0.1",1234);
		
		// 서버에서 전송하는 문자열을 읽을 수 있는 Scanner를 준비한다.
		Scanner sc = new Scanner(so.getInputStream());
		
		String content = "";			// 내용을 받아서 저장하기 위한 문자열 함수
		while(sc.hasNextLine()) {		// Scanner에 아직 처리하지않은 다음 줄이 남아있다면
			content += sc.nextLine() + "\r\n";	// 그 내용을 content에 더한다.
			
		}
		sc.close();	// Scanner닫기
		so.close();	// 소켓 닫기(연결 종료)
		
		System.out.println("==================");
		System.out.println(content); // 내용출력
		System.out.println("==================");
	}

}
