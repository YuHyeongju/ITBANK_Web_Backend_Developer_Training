package student;

public class Handler {

	private Student[] arr = new Student[5];

	public int addStudent(String name, int ban, int no, int kor, int eng, int math) { // 학생 추가 등록
		int row = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == null) {
				arr[i] = new Student();
				arr[i].setName(name);
				arr[i].setBan(ban);
				arr[i].setNo(no);
				arr[i].setKor(kor);
				arr[i].setEng(eng);
				arr[i].setMath(math);
				row = 1;
				break;
			}
		}
		return row;
	}

	public void showStudent() { // 학생 전체 목록
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != null) {
				System.out.printf("이름: %s\n반: %d\n번호: %d\n국어 점수: %d\n영어 점수: %d\n수학 점수: %d\n합계: %d\n평균: %.2f\n\n",
						arr[i].getName(), arr[i].getBan(), arr[i].getNo(), arr[i].getKor(), arr[i].getEng(),
						arr[i].getMath(), arr[i].getTotal(), arr[i].getAvg());
			}
		}
	}

	public void sortStudentByAvg() { // 평균으로 정렬
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; i < arr.length; i++) {
				if (arr[i] != null && arr[j] != null && arr[i].getAvg() - arr[j].getAvg() > 0) {
					Student tmp = arr[i];
					arr[i] = arr[j];
					arr[j] = tmp;
				}
			}
		}
	}

	public void sortStudentByName() { // 이름으로 정렬
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; i++) {
				if (arr[i] != null && arr[j] != null && arr[i].getName().compareTo(arr[j].getName()) > 0) {
					Student tmp = arr[i];
					arr[i] = arr[j];
					arr[j] = tmp;
				}
			}
		}

	}

	public void studentSearch(String searchName) { // 검색
		for (int i = 0; i < arr.length; i++) {
			if (arr[i].getName().contains(searchName) == true) { // searchName.equals(arr[i].getName()
				System.out.printf("이름: %s\n반: %d\n번호: %d\n국어 점수: %d\n영어 점수: %d\n수학 점수: %d\n 합계: %d\n평균: %.2f\n",
						arr[i].getName(), arr[i].getBan(), arr[i].getNo(), arr[i].getKor(), arr[i].getEng(),
						arr[i].getMath(), arr[i].getTotal(), arr[i].getAvg());
//				System.out.println(arr[i].info());
				break;
			}

		}
		System.out.println("그 학생은 존재하지 않습니다.");

	}

}
