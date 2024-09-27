package loginProj;

public class Member {
	private String id;
	private String pwd;
	private String nickname;
	
	public Member(String id, String pwd, String nickname) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.nickname = nickname;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	@Override
	public String toString() {
		return "Member [id=" + id + ", pwd=" + pwd + ", nickname=" + nickname + "]";
	}
}
