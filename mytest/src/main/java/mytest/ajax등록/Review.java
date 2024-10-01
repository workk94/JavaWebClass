package mytest.ajax등록;

public class Review {
	private String id;
	private String content;
	
	public Review() {
		// TODO Auto-generated constructor stub
	}
	
	public Review(String id, String content) {
		super();
		this.id = id;
		this.content = content;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Review [id=" + id + ", content=" + content + "]";
	}
	
	
}
