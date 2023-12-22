package binarySearch;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Ex03 {
	public static void main(String[] args) throws FileNotFoundException {
		ArrayList<String> list = new ArrayList<>();
		File f = new File("한국배우목록.txt");
		Scanner sc = new Scanner(f);
		
		while(sc.hasNextLine()) {
			String name = sc.nextLine();
			list.add(name);
		}
		sc.close();
		
		list.sort(null);
		
		
		System.out.println(list);		 // 내용 출력
		System.out.println(list.size()); // 전체 크기 확인
		
		sc = new Scanner(System.in);
		
		System.out.println("검색할 배우이름 입력: ");
		String name = sc.nextLine();
		
		
		int start = 0;
		int end = list.size() - 1;
		int answer = -1;
		
		
		while(start <= end) {
			int mid = (start + end) / 2;
			String test = list.get(mid);
			System.out.printf("%d ~ %d (%d) : %s\n",start, end , mid, test);
			
			if(test.equals(name)) {
				answer = mid;
				break;
			}
			
			else if(test.compareTo(name) > 0) {
				end = mid - 1;
			}else {
				
				start = mid + 1; 
			}
		}
		System.out.printf("%s는 %d번째에 있습니다.",name,answer);
		sc.close();
	}
}
