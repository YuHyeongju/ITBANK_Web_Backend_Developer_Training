package variable;

public class Ex05 {

	public static void main(String[] args) {
		//자료형 변환
		
		//기본적으로 대입시 좌변과 우변의 자료형이 같아야 한다.
		//좌변의 자료형이 더 범위가 크거나, 형태가 더 크다면 자동으로 형 변환이 이루어진다.
		//암묵적 형 변환, 묵시적 형 변환, promotion
		
		
		byte by = 10; //여기서 10은 리터럴 상태이다.
		int num = by; //(int) = (byte)
		System.out.println("num : " +  num);
		
		//좌변의 자료형이 더 범위가 작거나, 형태가 더 작거나 맞지 않으면 형 변환을 명시해야함.
		//명시적 형 변환 : casting
		//값 앞에 ()를 적고, 그 안에 바꾸고 싶은 자료형을 작성하면 된다.
		by =(byte)num;
		
		System.out.println("by: " + by);
		
		//값 자체가 변하는 것은 아니지만, 자료형에 따라서 수행할 수 있거나 수행할수 없는 작업이있다.
		//따라서 상황에 맞게 적절한 형 변환이 필요함.
		
		
	}

}
