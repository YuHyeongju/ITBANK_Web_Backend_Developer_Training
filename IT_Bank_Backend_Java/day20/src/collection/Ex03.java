package collection;

import java.util.ArrayList;
import java.util.Comparator;

public class Ex03 {

	public static void main(String[] args) {
		// 리스트의 정렬
		// 리스트를 정렬하기 위해서는 내부의 각 요소를 비교하기 위한 기준을 전달해야함.

		// 참고) 컬렉션의 제네릭 타입에는 primitive 타입은 지정 불가
		// ArrayList<int> list = new ArrayList<>(); (x)
		ArrayList<Integer> list = new ArrayList<>();
		list.add(25);
		list.add(55);
		list.add(72);
		list.add(15);
		list.add(49);
		System.out.println("list: " + list);

		// 오름차순 (정렬에서는 순서를 지정하지 않았을 때의 기본값)
		list.sort(null);
		System.out.println("list: " + list);

		// 내림차순 정렬하기
		// 1) 인터페이스는 추상클래스의 일종이므로, 익명 클래스 방식의 객체 생성가능
		Comparator<Integer> comp1 = new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {

				// return o1 - o2; // 오름차순 정렬
				 return o2 - o1; // 내림차순 정렬
			}
		};
		list.sort(comp1);
		System.out.println("1) list: " + list);
		
		// 2) Comparator는 함수형 인터페이스이므로, 람다식 객체 생성이 가능
		Comparator<Integer> comp2 = (o1 , o2) -> {
			return o2 - o1; // 내림차순 정렬 
		};
		list.sort(comp2);
		System.out.println("2) list: " + list);
		
		// 3) 람다식에서 body가 한 줄이면 {} 생략, return이면 return 생략
		list.sort((n1,n2) -> n2 - n1); // 내림차순 정렬
		System.out.println("3) list: "  + list);
		
		// 1,2,3 모두 같은 결과를 가져옴
	}

}
