package p3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component // 스프링 빈으로 등록하는 어노테이션 (ioc는 @component로 주입) -> 자동 의존주입
public class Car {
	
	
	@Autowired // 스프링 빈으로 등록된 객체 중에서 타입이 맞는 객체를 찾아서 자동으로 의존성을 주입한다.
	// DI는 @AutoWired로 주입 -> 자동 의존 주입      스프링 컨테이너에 있는 Tire 타입의 빈을 자동으로 주입 
	private Tire tire;
	
	public void run() {
		if(tire != null) {
			System.out.println("부릉부릉");
		}else {
			System.out.println("타이어를 먼저 장착 해야합니다.");
		}
	}
}
