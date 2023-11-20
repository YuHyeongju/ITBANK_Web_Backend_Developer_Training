package quiz;

import java.util.Random;
import java.util.Scanner;

public class Quiz01 {
	
    private static boolean isCorrent(int answer, int user) {
    	 boolean flag = false;
    	if(answer == user) {
    		flag = true;
    	}else {
    		flag = false;
    	}
    	return flag;
    }
	

	public static void main(String[] args) {
		Random ran = new Random();
		Scanner sc = new Scanner(System.in);
		int n1, n2, answer, user;
		
		n1 = ran.nextInt(10) + 1;
		
		n2 = ran.nextInt(10) + 1;
		
		answer = n1 + n2;
		
		System.out.printf("%d + %d = " , n1 , n2);
		user = sc.nextInt();
		
		boolean flag = isCorrent(answer,user);
		System.out.println(flag ? "정답" : "오답");
		sc.close();
		
		

	}

}
