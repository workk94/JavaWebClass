package day10;

public class Member {
	private String id;
	private String password;
	private String name;
	
	public Member() {
		// TODO Auto-generated constructor stub
	}
	
	public Member(String id) {
		super();
		this.id = id;
	}
	
	public Member(String id, String password) {
		super();
		this.id = id;
		this.password = password;
	}
	
	public Member(String id, String password, String name) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", password=" + password + ", name=" + name + "]";
	}
	
	
}
