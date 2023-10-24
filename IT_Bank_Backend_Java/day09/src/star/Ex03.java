package star;

public class Ex03 {
	public static void main(String[] args) {
/*		int size = 5;																	
		int st = 5;
		int sp = size - st;

		for (int i = 0; i < size; i++) {
			// 공백
			for (int j = 0; j < sp; j++) {
				System.out.print("  ");
			}
			// 별
			for (int j = 0; j < st; j++) {
				System.out.print("* ");
			}
			System.out.println(); // 한줄 끝나면 줄 변경
			st -= 1;
			sp += 1;
		}

	}

}*/
/*
 * * * * * 
  * * * * 
    * * * 
      * * 
        * 
 */



//		int size = 5;
//		int st = size;
//		int sp = size -st;
//
//		for (int i = 0; i < size; i++) {
//			// 공백
//			for (int j = 0; j < sp; j++) {
//				System.out.print("  ");
//			}
//			// 별
//			for (int j = 0; j < st; j++) {
//				System.out.print("* ");
//			}
//			// 공백
//			for (int j = 0; j < sp; j++) {
//				System.out.print("  ");
//			}
//
//			System.out.println(); // 한줄 끝나면 줄 변경
//
//			if (i < size / 2) { // 전체 줄 중에서 가운데 도달하지 못하면 (윗부분)
//				st -= 2;
//				sp += 1;
//				
//			} else { // 가운데를 줄이거나 아랫쪽이면
//				sp -= 1;
//				st += 2;
//
//			}
//		}
//	}
//}

		/*
		 * 
		*****
		 ***
		  *
		 ***
		*****
		*/

		int size = 9;
		int st = 1;
		int sp = size - st * 2;

		for (int i = 0; i < size; i++) {
			// 별
			for (int j = 0; j < st; j++) { // 0,1,2
				System.out.print("* ");
			}
			// 공백
			for (int j = 0; j < sp; j++) {
				System.out.print("  ");
			}//별
			for (int j = 0; j < st; j++) {  // 가운데 줄이고 , j 반복의 첫번째에서만
				System.out.print("* "); 	// j를 한번 더 증가(j를 2씩 증가)
				if (i == size / 2 && j == 0) {
					j++;
				}

			}
			System.out.println();

			if (i < size / 2) { // 전체 줄 중에서 가운데 도달하지 못하면 (윗부분)
				st += 1;
				sp -= 2;

			} else { // 가운데를 줄이거나 아랫쪽이면
				st -= 1;
				sp += 2;

			}
		}
	}
}
