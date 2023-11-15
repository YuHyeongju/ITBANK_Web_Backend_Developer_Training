package book6;

// create  table book(
//
//	    name            varchar2(100),    
//	    author           varchar2(100),
//	    publisher       varchar2(100),
//	    price             number
//	);
// 테이블을 구성하는 컬럼의 내용대로 멤버 필드를 작성한다.
// 멤버필드에 Private을 적용하고, getter/settert를 public으로 작성한다.
// 생성자 오버로딩이나 toString 오버라이딩은 상관없지만
// 반드시 기본 생성자가 존재하도록 구성해야한다.(매개변수가 없는)

public class BookDTO { // Data Transfer Object (DB <-> Program) , VO (Value Object)
	private String name;
	private String author;
	private int price;
	private String publisher;

	
	// 출력 서식을 toString으로 오버라이딩
	@Override
	public String toString() {
		String data = String.format("책이름: %s\n저자: %s\n출판사: %s\n가격: %,d원\n", 
				this.name, 
				this.author, 
				this.publisher,
				this.price);
		
		return data;
	}

	public String getName() {
		return name;
	}

	public String getAuthor() {
		return author;
	}

	public int getPrice() {
		return price;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public static void main(String[] args) {

	}

}
