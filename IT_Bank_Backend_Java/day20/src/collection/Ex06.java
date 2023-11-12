package collection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class Ex06 {

	public static void main(String[] args) {
		Random ran = new  Random();
		HashSet<Integer> set = new HashSet<>();
		
		while(set.size() != 6) {						// set의 size가 6이만 반복 종료
			int num = ran.nextInt(45) + 1;
			System.out.println("num : " + num);
			set.add(num);
		}
		ArrayList<Integer> list = new ArrayList<>(set);	// 정렬에 사용
		list.sort(null);
		System.out.println("set : " + set);
		System.out.println("list : " + list); 

	}

}

// List : 인터페이스
// ArrayList: List 인터페이스를 구현한 구현체