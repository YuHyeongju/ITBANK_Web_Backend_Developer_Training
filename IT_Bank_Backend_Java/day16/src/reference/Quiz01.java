package reference;

class Member {
	private String name;
	private int age;

	public Member(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	void show() {
		System.out.printf("%s : %d살\n", name, age);
	}

}

public class Quiz01 {

	public static void main(String[] args) {
		Member[] arr = new Member[] { new Member("원빈", 45), new Member("현빈", 41), new Member("우빈", 34),
				new Member("준빈", 31), new Member("다빈", 29) };
		System.out.println("===========");
		System.out.println("원본 배열 출력");
		System.out.println("===========");
		for (int i = 0; i < arr.length; i++) {
			arr[i].show();
		}
		System.out.println();

		// 이름을 기준으로 arr를 오름차순하는 함수를 만들어서 정렬을 수행하고 출력
		sortMemberArrayByName(arr);
		System.out.println("============");
		System.out.println("이름 기준 Sort");
		System.out.println("============");
		showSort(arr);
		// 나이를 기준으로 arr를 오름차순하는 함수를 만들어서 정렬을 수행하고 출력
		sortMemberArrayByAge(arr);
		System.out.println("============");
		System.out.println("나이 기준 Sort");
		System.out.println("============");
		showSort(arr);
	}

	// 객체와 객체는 직접적인 비교가 힘들기때문에
	// 특정 필드 값을 기준으로 정렬해야한다.
	// primitive 타입이거나, compareTo 함수가 있는 자료형으로 기준을 선정(String)

	static void sortMemberArrayByName(Member[] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				// Member끼리는 비교가 안된다.
				// 객체 그 자체 대신, 객체의 이름을 꺼내와서 비교해야한다.

				// 문자열끼리는 연산자로 비교할 수 없음으로, compareTo를 활용한다.
				if (arr[i].getName().compareTo(arr[j].getName()) > 0) {
					Member tmp = arr[i];
					arr[i] = arr[j];
					arr[j] = tmp;
				}
			}
		}

	}

	static void sortMemberArrayByAge(Member[] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i].getAge() - arr[j].getAge() > 0) {
					Member tmp = arr[i];
					arr[i] = arr[j];
					arr[j] = tmp;
				}
			}
		}
	}

	static void showSort(Member[] arr) {
		for (int i = 0; i < arr.length; i++) {
			arr[i].show();
		}
		System.out.println();
	}

}
