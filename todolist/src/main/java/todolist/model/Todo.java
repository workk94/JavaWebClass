package todolist.model;

public class Todo {
	private String id;
	private String content;
	private String creatAt;
	
	public Todo() {
		// TODO Auto-generated constructor stub
	}
	
	public Todo(String id, String content, String creatAt) {
		super();
		this.id = id;
		this.content = content;
		this.creatAt = creatAt;
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

	public String getCreatAt() {
		return creatAt;
	}

	public void setCreatAt(String creatAt) {
		this.creatAt = creatAt;
	}

	@Override
	public String toString() {
		return "Todo [id=" + id + ", content=" + content + ", creatAt=" + creatAt + "]";
	}
	
	
}
