package star;

public class Ex01 {

	public static void main(String[] args) {
		// num 과 i를 더했을떄 항상 5가 나오는 식
//		for (int i = 0; i < 5; i++) {
//			int num = 5 - i;
//			System.out.printf("%d, %d\n", i, num);
//		}
//		System.out.println();
//		
//		

		for (int i = 1; i <= 5; i++) {
			

			int num = 5 - i;

			for (int j = 0; j < num; j++) { 	//	5,4,3,2,1
				System.out.print("  ");			// 한 줄 안에서 먼저 나오는 글자 개수
			}
			for (int j = 1; j < i + 1; j++) {	// 0,1,2,3,4
				System.out.print("# ");			// 한 줄 안에서 나중에 나오는 글자 개수 	
			}	
			System.out.printf("\t%d, %d",num,i); // 개수 확인용 출력
			System.out.println();				 // 한 줄의 출력이 끝나면 줄을 바꾼다.

		}
	
	}
}

/*
        # 	4, 1
      # # 	3, 2
    # # # 	2, 3
  # # # # 	1, 4
# # # # # 	0, 5
*/
