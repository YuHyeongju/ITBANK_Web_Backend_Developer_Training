package p1;

import org.springframework.context.support.GenericXmlApplicationContext;

public class Main2 {
	public static void main(String[] args) {
		// Context init  = new InitialContext();
		
		GenericXmlApplicationContext context = 
				new GenericXmlApplicationContext("classpath:hello-context.xml");
		
		// 지정한 타입의객체가 컨테이너 안에 하나만 있다면 자료형만 불러 올 수 있음.
		Hello ob1 = context.getBean(Hello.class);
		
		// 지정한 타입의 객체가 컨테이너 안에 두개 이상 있으면 id를 지정하여 불러올 수 있음. 
		Hello ob2 = context.getBean("hello",Hello.class);
		//hello-context.xml 안에 정의해놓은 hello라는 객체를 호출
		
		System.out.println(ob1.getText()); 
		System.out.println(ob2.getText());
		System.out.println();
		
		System.out.println(ob1 == ob2);
		
		// 스프링은 내부에 스프링 컨테이너라는 객체 보관소를 가진다
		// 스프링 컨테이너 내부에 준비된 객체를 스프링 빈이라 부른다.
		// 스프링빈은 별도의 추가 설정이 없으면 기본적으로 싱글톤을 구현한다.
		// 스프링 컨테이너에 객체를 생성하기 위해서 xml 설정파일을 활용하여 처리한다
		// 이떄 xml파일은 컨테이너 내부에 객체를 준비하기 위한, 주문서 개념으로 생각한다.
		
		context.close();
	}
}
