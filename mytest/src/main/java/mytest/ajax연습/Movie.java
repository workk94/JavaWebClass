package mytest.ajax연습;

public class Movie {
	String title;
	String director;
	String genre;
	int runningTime;
	
	public Movie() {
		// TODO Auto-generated constructor stub
	}
	
	public Movie(String title, String director, String genre, int runningTime) {
		super();
		this.title = title;
		this.director = director;
		this.genre = genre;
		this.runningTime = runningTime;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public int getRunningTime() {
		return runningTime;
	}

	public void setRunningTime(int runningTime) {
		this.runningTime = runningTime;
	}

	@Override
	public String toString() {
		return "Movie [title=" + title + ", director=" + director + ", genre=" + genre + ", runningTime=" + runningTime
				+ "]";
	}
	
	
	
	
}
