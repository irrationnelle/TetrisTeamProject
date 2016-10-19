package Final;

public class ScoreVO {
	private int userID;
	private String name;
	private int score;

	public ScoreVO() {}

	public ScoreVO(int userID, String name, int score) {
		super();
		this.userID = userID;
		this.name = name;
		this.score = score;
	}
	
	public ScoreVO(String name, int score) {
		super();
		this.name = name;
		this.score = score;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	
}
