package book5;

public class Book { // 필드만 있는 클래스
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
