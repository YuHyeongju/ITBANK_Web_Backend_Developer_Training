package loop;

public class Ex09 {

	public static void main(String[] args) {
		// 1) 1부터 5까지 한줄에 출력하기
		for(int i = 1; i <6; i++) {
			System.out.print(i + " ");
		}System.out.println("\n");
		
		//2) 1부터 5까지 한줄 출력코드를 다시 5번 출력
		 for(int i = 1; i < 5; i++) {
			 for(int j = 1; j <=5; j++) {
				 System.out.print(j+ " ");
			 }
			 System.out.println();
		 }
		 System.out.println("\n");
		 
		 //3) 다른 변수를 만들어두고 1부터 25까지 5x5 크기로 출력하기
		 int  num = 1;
		 for(int i = 0; i < 5; i++) {
			 for(int j = 0; j < 5; j++ ) {
				 System.out.printf("%2d " , num);
				 num++;
			 }
			 System.out.println();
		 }
		 System.out.println();
		 
		 
		 //4) (i,j)번 째 칸에 원하는 글자를 출력하기
		 for(int i = 0; i < 5; i++) {
			 for(int j = 0; j < 5; j++ ) {
				 if(i == 2 || j == 2) {
					 System.out.print("# ");
				 }else {
					 System.out.print("  ");
					 
				 }
			 }
			 System.out.println();
		 }
		 System.out.println();
		 
		 
		 for(int i = 0; i < 5; i++) {
			 for(int j = 0; j < 5; j++ ) {
				 if(i % 4 == 0 || j % 4 == 0 ) {
					 System.out.print("# ");
				 }else {
					 System.out.print("  ");
					 
				 }
			 }
			 System.out.println();
		 }
		 System.out.println();

		 
		 
		 for(int i = 0; i < 5; i++) {
			 for(int j = 0; j < 5; j++ ) {
				 //if(i % 2 == 0 && j % 2 == 0 || i % 2 == 1 && j % 2 == 1 ) {
				 //if(n1 % 2 == 1){
				 if((i+j) % 2 == 0) {
					 System.out.print("# ");
				 }else {
					 System.out.print("  ");
					 
				 }
			 }
			 System.out.println();
		 }
		 System.out.println();
		 
		 
		 
	}

}
