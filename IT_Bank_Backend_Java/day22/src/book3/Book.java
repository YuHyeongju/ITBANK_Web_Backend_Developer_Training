package book3;

// 접근 제한자 + setter/getter 적용

public class Book { // 필드만 있는 클래스 
	private String name;
	private String author;
	private int price;
	
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

	String publisher;

	public static void main(String[] args) {

	}

}
