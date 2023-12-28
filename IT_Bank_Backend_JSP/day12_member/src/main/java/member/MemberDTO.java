package member;


/*이름       널?       유형            
-------- -------- ------------- 
USERID   NOT NULL VARCHAR2(500) 
USERPW   NOT NULL VARCHAR2(500) 
USERNAME NOT NULL VARCHAR2(500) 
GENDER            VARCHAR2(100) 
EMAIL    NOT NULL VARCHAR2(100) */

public class MemberDTO {
	
	private String userpw;
	private String userName;
	private String gender;
	private String email;
	private String userid;

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUserpw() {
		return userpw;
	}

	public void setUserpw(String userpw) {
		this.userpw = userpw;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


}
