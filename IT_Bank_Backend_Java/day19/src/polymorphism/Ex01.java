package polymorphism;

class Animal { // 공통 기능과 속성은 슈퍼 클래스에
	String name;

	Animal(String name) {
		this.name = name;
	}

	// 서로 다른 동물의 공통점
	// 다리가 4개이다. , 꼬리가 있다. , 털이 있다. , 말을 못한다.(울음소리를 낸다)
	void bark() {
		System.out.println(name + ": ...");
	}
}

class Dog extends Animal { // 오버라이딩 및 개별 고유 기능은 서브클래스에
	Dog(String name) {
		super(name);
	}

	@Override
	void bark() { // 슈퍼클래스의 공통 기능을 상속받은 후 내용을 재정의함.(서브클래스마다 달라지는 내용)
		System.out.println(name + ": 멍멍");
	}

	void tailing() { // 다른 Animal에서는 없는 Dog만의 고유기능(Dog가 아니면 동작하지 않는다.)
		System.out.println(name + "꼬리를 흔든다.");
	}

}

class Cat extends Animal { // 오버라이딩 및 개별 고유 기능은 서브클래스에
	Cat(String name) {
		super(name);
	}

	@Override
	void bark() {
		System.out.println(name + ": 야옹");
	}

	void play() { // 고양이의 고유 기능
		System.out.println(name + "가 혼자서 잘논다.");
	}
}

public class Ex01 {

	public static void main(String[] args) {
		Cat cat = new Cat("해피");
		Dog dog = new Dog("뽀삐");

		cat.bark();
		dog.bark();

		cat.play();
		dog.tailing();

		// 상속관계는 카테고리 (범주)상 포함관계일때 사용할 수 있다.
		// A is B 관계가 성립해야한다.
		// 강아지는 동물이다.
		// 고양이는 동물이다.
		// 올바른 상속관계라면, A를 B로 치환해서 사용할 수 있어야 한다.

		Animal a1 = cat;
		Animal a2 = dog;

		System.out.println(a1 == cat);
		System.out.println(a2 == dog);
		System.out.println(a1);
		System.out.println(cat);
		System.out.println(a2);
		System.out.println(dog);
		System.out.println();
		// a1과 cat은 서로 동일한 대상을 참조하고 있다.
		// 다만, a1의 자료형은 Animal이고, cat의 자료형은 Cat이다.
		// a1으로 참조하면 Animal 클래스에서 작성된 내용만 참조할 수 있고,
		// cat으로 참조하면 Cat 클래스에 작성된 내용까지 모두 참조할 수 있다.

		// a1.play() // Animal 클래스에는 play() 메서드가 없다.(Cat의 고유기능)
		// a2.tailing // Animal 클래스에는 tailing 메서드가 없다.(Dog의 고유기능)

		a1.bark(); // 슈퍼클래스 Animal 에는 name + ":..." 으로 정의되어있으나
		a2.bark(); // 걱 서브클래스의 오버라이딩 내용으로 실행된다.
		System.out.println();
//		Animal[] arr = {a1,a2};
		Animal[] arr = { cat, dog };
		// upcasting : 서브클래스의 객체를 슈퍼클래스로 참조하는 형태 (자료형 변환)

		// 묶어서 처리하기위해서 cat과 dog을 업캐스팅해서 Animal로 만들었다.

//***************************************************************************************************
// 방법 1		
		for (int i = 0; i < arr.length; i++) { // Object 클래스의 getClass()
			String className = arr[i].getClass().getSimpleName();
			System.out.println("arr[i]의 클래스이름: " + className);

			// arr[i].play(); 	  // Cat의 고유메서드(실행안됨)
			// arr[i].tailing();  // Dog의 고유메서드 (실행안됨)
			arr[i].bark();        // Animal의 공통메서드 (실행가능, 내용은 각자 다름)

			switch (className) {	// 서브클래스의 고유기능을 사용하기위해 다운캐스팅 후 객체가 cat이나 dog가 맞는지 
			case "Cat":				// 확인 작업
				Cat tmp1 = (Cat) arr[i]; // 강제 형변환, downcasting
				tmp1.play();
				break;
			case "Dog":
				Dog tmp2 = (Dog) arr[i]; // 강제 형변환, downcasting
				tmp2.tailing();
				break;
			}
// **************************************************************************************************			
// 방법 2
			// 업캐스팅 된 객체를 원래대로 돌리기위해 다운캐스팅 하기위해 확인작업이 필요하다.
			if (arr[i] instanceof Cat) { // 객체 instanceof 클래스
				Cat tmp1 = (Cat) arr[i];
				tmp1.play();
			}
			if (arr[i] instanceof Dog) { // 지정한 객체가 클래스에 의해 생성된 객체인가 확인하는 연산자
				Dog tmp2 = (Dog) arr[i];
				tmp2.tailing();
			}
//****************************************************************************************************			
		}
	}

}
