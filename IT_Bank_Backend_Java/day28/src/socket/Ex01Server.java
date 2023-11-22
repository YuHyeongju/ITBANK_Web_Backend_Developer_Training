package socket;


import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Ex01Server {                                    

	public static void main(String[] args) throws Exception {
		// 내 컴퓨터가 서버 역할을 할 수 있도록 지정한 포트를 이용하여 소켓을 개설할 준비를 한다.
		ServerSocket ss = new ServerSocket(1234);
		
		// 날짜 형식을 이용하여 문자열을 준비한다.
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 E요일");
		String str = "안녕하세요\r\n";
		str += "오늘은 %s 입니다.\r\n";
		str += "저는 유형주입니다.\r\n";
		str = String.format(str,sdf.format(new Date())) ;
		
		
		for(int i = 0; i < 5; i++) {
		//  서버를 실행하고 다른 프로그램이 접속하기를 기다린다.
		
		System.out.println("서버 실행, 접속 대기중...");
		Socket so = ss.accept();	// 대상이 접속하면 , 대상을 가리키는 소켓이 생성됨
									// LISTEN 상태로 접속을 기다린다.
		
		// 대상이 접속하면 대상의 아이피주소를 출력한다.
		System.out.printf("%s 접속합\n",so.getInetAddress() );
		
		// 대상에게 글자를 내보낼 수 있는 Stream -> writer -> bufferdWriter를 생성한다.
		OutputStreamWriter osw = new OutputStreamWriter(so.getOutputStream(), "UTF-8");
		BufferedWriter bw = new  BufferedWriter(osw);
		
		bw.write(str); // 문자열을 내보낸다.
		bw.flush();
		bw.close();
		
		so.close();   // 소켓 연결 종료
		ss.close();	  // 서버 소켓 연결 종료
		}
	}

}
