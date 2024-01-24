package p3;

import org.springframework.context.support.GenericXmlApplicationContext;

public class Main4 {
	public static void main(String[] args) {
		GenericXmlApplicationContext context = new GenericXmlApplicationContext("classpath:car-context.xml");
		// 경로에 있는 context.xml에 가서 생성된 객체에 접근한다.
		Car ob1 = context.getBean(Car.class); // car 클래스의 빈을 호출해서 ob1에 저장
		ob1.run(); // 빈을 실행
		
		context.close();
	}
}
