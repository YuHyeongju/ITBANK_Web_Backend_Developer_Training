package quiz;

import java.util.Scanner;

public class Quiz04 {

	public static void main(String[] args) {
		//	지하철 1구간당 평균 소요 시간이 4분이라 가정한다.
		//	이동한 구간 수를 입력받아서 이동하는데 걸리는 시간을 출력하세요.
		//	단, 이동한 시간이 60 이하면 분으로만 출력하고 
		//	이동한 시간이 60분을 초과하면 시간과 분으로 나누어 출력하세요.
		
		int time = 4 , station; 
		int totalTime;
		int hour;
		int min;
		
		
		
		Scanner sc = new Scanner(System.in);			
		
		System.out.println("이동한 구간 수를 입력하세요: ");	//입력받기
		
		station = sc.nextInt();							//입력받은 구간 수를 station에 저장 
		
		totalTime  =  station * time;					//전체시간 : 시간 * 구간 갯 수
		
		hour = totalTime / 60; 							
		min = totalTime % 60;
		
		
		if(totalTime <= 60) {							//60분이하 : 그냥출력
			System.out.println(min + "분 소요");
		}else if(totalTime > 60) {						//60분 이상 : 시간과 분으로 나누어 출력
			System.out.println(hour + "시간" + min + "분 소요");
		}
		
		sc.close();
	}

}
