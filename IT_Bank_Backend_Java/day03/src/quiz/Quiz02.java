package quiz;

import java.util.Scanner;

public class Quiz02 {

	public static void main(String[] args) {
		// 친구와 고기집에 갔다.
		//이 식당에서는 첫 주문에 최소 3인분을 주문해야하고,
		//이후에는 1인분씩 추가가 가능하다.
		//돼지고기 삼겹살 1인분이 8500원이고
		//소주1병(4500원), 맥주1병(5000원)을 고정으로 주문했다.
		//추가 주문한 삼겹살 양을 입력받아서 총 결제해야 할 금액을 계산하고, 
		//더치페이로 1인당 얼마를 내야 하는지 계산해서 출력하는 프로그램을 작성하시오.
		
		
		int basicOrder = 25500;
		int addOrder;
		int p_sum;
		int beer = 5000;
		int soju = 4500;
		int n_price;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("추가 주문할 삼겹살의 인분 수를 입력하여주세요:  ");
		
		addOrder = sc.nextInt();
		
		p_sum = basicOrder + (addOrder * 8500) + soju + beer;
		
		System.out.println("총 결제해야 할 금액: " + p_sum +"원");
		
		n_price = p_sum / 2;
		
		System.out.println("1인당 내야할 금액: " + n_price + "원");
		
		sc.close();
		
		
		
		
		
		

	}

}
