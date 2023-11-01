package book;


// 단일 데이터를 필드와 getter/setter로 구성

public class Book {
	public String bookName, author;  
	public int bookNum;

	public String getBookName() {
		return bookName;
	}

	public String getAuthor() {
		return author;
	}

	public int getBookNum() {
		return bookNum;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setBookNum(int bookNum) {
		this.bookNum = bookNum;
	}
	
	
	
	
}
