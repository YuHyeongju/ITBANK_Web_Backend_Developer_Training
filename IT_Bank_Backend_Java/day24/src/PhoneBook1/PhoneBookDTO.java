package PhoneBook1;

public class PhoneBookDTO {
	private String name; // 이름
	private String pnum; // 전호번호
	private int age; // 나이
	private String favorite; // 즐겨찾기, (Y 혹은 N 으로만 넣을 수 있음)

	
	@Override
	public String toString() {
		String form = "%s %13s %s살 %s";
		form = String.format(form, name,pnum ,age,(favorite.equals("Y") ? "★" : "☆"));
		return form;
	}
	
	public String getName() {
		return name;
	}

	public String getPnum() {
		return pnum;
	}

	public int getAge() {
		return age;
	}

	public String getFavorite() {
		return favorite;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPnum(String pnum) {
		this.pnum = pnum;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setFavorite(String favorite) {
		this.favorite = favorite;
	}

}
