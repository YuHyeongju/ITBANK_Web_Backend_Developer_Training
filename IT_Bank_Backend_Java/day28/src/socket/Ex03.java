package socket;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Ex03 {
	public static void main(String[] args) throws Exception {

		File f = new File("index.html");
		Scanner sc = new Scanner(f);

		ServerSocket ss = new ServerSocket(1234);

		System.out.println("접속 대기중...");
		Socket so = ss.accept();
		System.out.println("접속 : " + so.getInetAddress());

		OutputStreamWriter osw = new OutputStreamWriter(so.getOutputStream(), "UTF-8");
		BufferedWriter bw = new BufferedWriter(osw);

		while (sc.hasNextLine()) {
			String data = sc.nextLine();
			bw.write(data + "\r\n");
		}
		bw.flush();
		bw.close();
		sc.close();
		so.close();
		ss.close();

	}
}
