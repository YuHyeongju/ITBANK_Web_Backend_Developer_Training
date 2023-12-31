package book;

public class BookDTO {
	
	private int idx;
	private String title;
	private String author;
	private String publisher;
	private String publishDate;
	
	
	private static int seq = 0; // 인덱스를 증가시켜줄 시퀀스 초기화
	
	public static int getSeq() {
		return seq;
	}
	
	public BookDTO() {
		this.idx = ++seq; // 객체를 생성할 때 마다 시퀀스가 하나씩 증가 하여 idx에 대입
	}
	
	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}
	
	
}
