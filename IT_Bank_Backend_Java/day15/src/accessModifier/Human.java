package accessModifier;

public class Human {

	// 일반적으로 필드는  private, 메서드는 public으로 설정한다.
	private String name;
	private int age;
	
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	// getter/setter 메서드를 자동으로 작성할 수 없다.
	// 내부 멤버필드의 값을 그대로 반환하여 외부에서 사용할 수 있도록 하는 함수 getter
	// 매개변수의 값을 전달하여 그 값을 내부 멤버필드에 대입하는 함수 setter
	
	
	// 필드/메서드를 이름은 camelcase를 적용하여 작성한다.
	// 단어와 단어를 합성하여 만들어낸 이름의 경우, 각 단어의 첫 글자만 대문자로 치환하는 방법
	
	// 저장 - 이클립스 편집기 우클릭  - source - generate getters and setters
	

	

}
