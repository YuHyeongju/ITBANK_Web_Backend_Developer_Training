package book5;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner;

// 데이터 저장소(배열 -> 리스트 -> 파일 -> DB)를 직접 참조하거나, 연결할 수 있음.

// 프로그램의 주요 기능(목록/추가/삭제 등)을 모아둔 클래스

public class Handler {

	// private Book[] arr = new Book[10];
	// 배열에서 리스트로 전환 (배열의 자료형은 리스트가 된다)
	private ArrayList<Book> list = new ArrayList<>();

	// 파일 저장 및 불러오기 함수
	private File f = new File("bookList.csv");

	public Handler() {
		if (f.exists() == false) {  // 파일이 존재하지 않으면
			try {
				f.createNewFile();	// 파일 만들기
			} catch (IOException e) {
				System.out.println("\t파일을 생성하는데 문제가 발생했습니다. : " + e);
				e.printStackTrace();
			}
		}
	}
	// 저장
	public void save() {
		try {
			// 프로그램의 데이터를 파일로 내보내는 스트림(데이터의 이동 경로)
			FileOutputStream fos = new FileOutputStream(f);
			// 스트림으로 문자열 형식 데이터를 전달하는 기능이 추가된 클래스
			OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");

			for (Book ob : list) {
				String name = ob.getName();
				String author = ob.getAuthor();
				String publisher = ob.getPublisher();
				String price = String.valueOf(ob.getPrice()); // valueOf 해당 객체를 String 객체로 변환 

				// 아래 서식은 띄어쓰기 없이 콤마로만 구분

				String data = String.format("%s, %s, %s, %s", name, author, publisher, price);
				osw.write(data);
				osw.write("\n");

			}
			osw.flush(); // 버퍼에 저장된 내용을 파일에 저장
			osw.close();

		} catch (IOException e) {
			e.printStackTrace();

		}
	}

	public void load() {
		try {
			Scanner sc = new Scanner(f);
			String data = "";
			while(sc.hasNextLine()) { // 다음에 데이터가 있으면
				data = sc.nextLine(); 
				if(data.length() != 0) {
					String[] arr = data.split(","); // 콤마를 기준으로 구분해서 배열에 저장
					Book b = new Book();
					b.setName(arr[0]);
					b.setAuthor(arr[1]);
					b.setPublisher(arr[2]);
					b.setPrice(Integer.parseInt(arr[3]));
					list.add(b); // 수정한 데이터를 리스트에 추가
				}
			}
			
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	public void showList() {
		list.forEach(ob -> System.out.println(ob)); // 위의 향상된 for문에서 사용한 ob를 가져와서 출력
	}

	public int insertBook(Book ob) {
		int row = 0;

		boolean flag = list.add(ob); 	
		row = flag ? 1 : 0;				
		return row;
	}

	public int deleteBook(String name) {
		int row = 0;
	
		boolean flag = list.removeIf(ob -> ob.getName().equals(name)); // 조건절이 성립하면 삭제
		row = flag ? 1 : 0;
		return row;
		
		
	}

}	
	