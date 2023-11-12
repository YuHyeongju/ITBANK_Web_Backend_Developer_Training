package collection;

import java.util.Arrays;
import java.util.List;

class Book implements Comparable<Book>{
	String name;
	int price;
 
	public Book(String name, int price){
		this.name = name;
		this.price = price;
	}

	@Override
	public String toString() {
		return String.format("%s : %,d원\n", name, price);
	}
	
	@Override
	public int compareTo(Book other) {
		return this.price;
	}

}

public class Quiz01 {
	static void showList(List<Book> list) {
		for (Book b : list) { 	   // 리스트의 각각의 값을 b라 할때 b를 출력하시오 
			System.out.println(b); // toString을 오버라이딩 해주면 b를 참조할 필요가 없다.
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Book[] arr = { new Book("전지적 푸바오 시점", 19800), new Book("더 마인드", 17820), new Book("트렌드 코리아", 17100),
				new Book("김대리의 데일리 뜨개", 18900), new Book("퓨처 셀프", 17820) };

		List<Book> list = Arrays.asList(arr);
		showList(list);

		// 제목 기준 오름차순
		System.out.println("제목 기준 오름차순");
		System.out.println();
		list.sort((o1, o2) -> o1.name.compareTo(o2.name));
		showList(list);
		
		System.out.println();
		
		list.sort((o1, o2) -> {
			int diff = o1.name.compareTo(o2.name);
			System.out.printf("[%s] 와 [%s]를 비교한 차이값:%d]\n", o1.name, o2.name, diff );
			return diff;
		});
		
		System.out.println();
		
		// 가격 기준 내림차순
		System.out.println("가격 기준 내림차순");
		System.out.println();
		list.sort((o1, o2) -> o1.price - (o2.price));
		showList(list);
		
		
		// Book 클래스는 기본 비교 함수가 내장되어 있지 않기 때문에 예외 발생
		// 기본 비교 함수를 넣어주려면 인터페이스  Comparable을 구현하면 됨.
		
		// Comparable: 클래스에서 implements해서 사용하는 인터페이스
		// class Book implements Comparable { 비교 가능한 도서( compareTo를 오버라이딩) }
 		
		// comparator : 람다식으로 객체를 생성하여 전달할 때 사용
		// 비교함수가 없거나, 자신만의 기준으로 비교하고 싶을때 만들어서 전달
		list.sort(null);
		showList(list);
		
		// Comparerator 인터페이스 ->   compare(T o1, T o2) 구현, 두 매개변수 객체 비교
		// Comparable 인터페이스 ->  compareTo (T o) 구현, 자기자신과 매개변수 객체 비교, null을 넣으면 자체 기준 사용
		
		
		// list.sort() 함수는 내부에서 자기만의 방식으로 정렬을 수행함.
		// 이때, 선택정렬 코드의  if조건에 해당하는 부분만 만들어내는 함수가 compare, compareTo이다.
		// if (arr[i] - arr[j] > 0 {...} 에서 arr[i] - arr[j] 부분을 만드는 함수가 Comparerator이다.
	}

}



