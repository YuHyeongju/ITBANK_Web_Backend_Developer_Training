package quiz;

import java.util.Random;
import java.util.Scanner;

public class Quiz05 {

	public static void main(String[] args) {
		Random ran = new Random();
		int eleA, eleB, eleC;
		int floor, FDA,FDB,FDC;
		int min_d;
		String open_ele= " ";
		
		eleA = ran.nextInt(15) + 1; //1~15
		eleB = ran.nextInt(15) + 1; //1~15
		eleC = ran.nextInt(15) + 1; //1~15
		
		System.out.printf("현재 엘리베이터들의 위치: %d, %d, %d\n", eleA, eleB, eleC);
		
		// 현재 자신의 위치를 1 ~ 15 사이로 입력한 다음
		// 가장 가까운 엘리베이터가 몇번째인지 출력하는 코드를 작성하세요.
		//(가장 가깝다 = 거리값이 최소 = 차이가 절대값이 최소값이다.)
		
		System.out.printf("현재 나는 몇 층? : ");  //현재 위치 입력
		
		Scanner sc = new Scanner(System.in);
		
		floor = sc.nextInt();					//입력 받은 현재 위치를 저장 
		
		FDA = eleA - floor ;  					//엘리베이터 위치에서 현재 층 수를 빼줌.
		FDB = eleB - floor ;
		FDC = eleC - floor ;
		
		if(FDA < 0) FDA *= -1;					//절댓값 적용
		if(FDB < 0) FDB *= -1;
		if(FDC < 0) FDC *= -1;
			
		min_d = FDA;  							//가까운 엘리베이터에 A엘베 대입
		
		if(min_d > FDB) min_d = FDB;			//비교
		if(min_d > FDC) min_d = FDC;		
				
		if(min_d == FDA) open_ele = "A";		//최소 엘베가 A면 open_ele변수에 "A" 저장
		if(min_d == FDB) open_ele = "B";		//최소 엘베가 B면 open_ele변수에 "B" 저장
		if(min_d == FDC) open_ele = "C";		//최소 엘베가 C면 open_ele변수에 "C" 저장
		
		
		System.out.printf("가장 가까운 엘리베이터는 %s 엘리베이터입니다.", open_ele ); //출력
		
		
		sc.close();		//스캐너 종료

	}

}
