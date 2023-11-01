package accessModifier;

import java.util.Scanner;

public class Ex04 {

	public static void main(String[] args) {
		// Human 타입의 객체를 저장할 수 있는 배열을 준비
		// while, switch ~ case를 이용하여 메뉴를 선택하는 형식
		// 메뉴 선택에 따라 입력 및 출력을 수행하는 프로그램
		
		
		Scanner sc = new Scanner(System.in);
		Human[] arr = new Human[5];				// Human 객체를 담을 수 있는 빈칸이 연속으로 5칸 준비됨.
		int menu;
		String name = ""; 
		int age = 0;
		boolean hasNull = false; // 빈칸이 하나라도 있으면  true
		
		while(true) {
			System.out.println("1.입력 ");
			System.out.println("2.출력 ");
			System.out.println("0.종료 ");
			System.out.println("선택 >>>");
			menu = sc.nextInt();
			switch(menu) {
			case 1:				// 빈칸을 찾아서 빈칸에 데이터를 입력하고 반복탈출
								// 만약 모든 칸이 채워져서 빈 칸이 없으면 메시지 출력
				
				for(int i = 0; i <arr.length; i++) {
					// 빈칸이 하나라도 있는지 없는지 체크
					hasNull = false;
					
					// 여러 칸중에 빈칸인 곳을 하나 찾아서 
					if(arr[i] == null) {
						hasNull = true;
						// 객체를 구성할 값을 사용자로부터 입력받고
						System.out.print("이름 입력: ");
						name = sc.next();
						System.out.print("나이 입력: ");
						age = sc.nextInt();
						// 빈칸에 객체를 생성한 다음 값을 넣어준다.
						arr[i] = new Human();
						arr[i].setName(name); // setter
						arr[i].setAge(age); // setter
						// 빈칸을 찾아서 데이터를 입력했으니 입력을 중단한다.
						break; // 다음칸이 빈칸인지 확인할 필요가 없다.(이미 입력 했기때문)
					}
				}
				if(hasNull == false) {
					System.out.println("더 이상 빈칸이 없습니다.");
				}
				break;
				
			case 2:				// 빈칸을 제외한 모든데이터를 화면에 출력
								// 모든 칸이 비어있으면 아무것도 출력하지않음.
				for (int i = 0; i < arr.length; i++) { 	
					if (arr[i] != null) {
						System.out.printf("%s : %d살\n",arr[i].getName(),arr[i].getAge());
					}
				}
				break;
				
			case 0:
				sc.close();
				return;
				
			default:
				System.out.println("잘못 입력하셨습니다.");
			}
			System.out.println();
		}

	}

}

// nextLine()   줄바꿈문자까지 처리함.
// next()	 	줄바꿈문자 전까지 처리함.
