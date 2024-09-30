package food;



public class Movie {
	String title;
	String actor;
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getActor() {
		return actor;
	}
	public void setActor(String actor) {
		this.actor = actor;
	}
	@Override
	public String toString() {
		return "Movie [title=" + title + ", actor=" + actor + "]";
	}
	public Movie(String title, String actor) {
		super();
		this.title = title;
		this.actor = actor;
	}	
	
	public Movie() {
		// TODO Auto-generated constructor stub
	}

}
