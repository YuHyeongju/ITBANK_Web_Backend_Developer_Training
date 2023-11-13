package exception;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class EX05 {
	public static void main(String[] args) throws IOException {
		// try: 예외발생 가능성이 있는 코드를 작성
		// catch: try에서 예외가 발생하면 지정한 타입의 예외를 받아서 처리함.
		//        하나의  try에 여러 catch를 작성 할 수 있음.
		//        이때, 순서는 상세한 것 부터 포괄적인 예외 순으로 작성함.
		// 		  맨아래의 catch(Exception e)를 작성하면 모든 예외에대한 처리가 된다.,
		// fanally: 예외 발생 여부에 상관없이 항상 실행되는 코드를 작성한다. 주로 마무리 코드를 작성한다.
		// throw: 임의로 예외 객체를 생성한 다음, 생성된 예외 객체를 catch에게 넘기는 용도로 사용
		// throws: 메서드 매개변수 옆에 작성하여 해당 함수에서 발생하는 예외를 caller에게 전가한다.
		
		// 예외 타입에 따라서, try ~ catch로 처리하지 않아도 실행은 가능한 예외가 있고
		// 특정 예외는 반드시 예외처리를 해야만 실행되는 코드도 있다.
		// 주로, 입출력 및 네트워크 통신에 관련된 예외는 반드시 예외처리를 선행해야함.
		
		URL url = new URL("http://www.naver.com");
		// throws MalformedURLException
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		// throws IOException
		Scanner sc = new Scanner(conn.getInputStream());
		// throws IOException
		
		String str = "";
		while(sc.hasNextLine()) {
			str += sc.nextLine();
		}
		str = str.replace(">",">\n");
		sc.close();
		conn.disconnect();
		System.out.println(str);
		System.out.println(str.length());
		
		
	}
}