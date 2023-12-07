package ex06;

public class MemberDTO {
	private String name;
	private String imgPath;
	
	public MemberDTO() {	// 매개변수가 없는 기본생성자를 생성해놓아야 beans 로써 사용 가능하다.
		
	}
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
		this.imgPath = "image/" + name + ".png";
	}
	public String getImgPath() {
		return imgPath;
	}
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
}
