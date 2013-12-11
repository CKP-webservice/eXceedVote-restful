package exceedvote.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;

@XmlRootElement(name="contestant")
@XmlAccessorType(XmlAccessType.FIELD)
public class RankScore {
	@XmlElement(name="id")
	private int contestantID;
	private String name;
	private int score;
	
	public RankScore(int contestantID, String name, int score) {
		super();
		this.contestantID = contestantID;
		this.name = name;
		this.score = score;
	}

	public int getContestantID() {
		return contestantID;
	}

	public void setContestantID(int contestantID) {
		this.contestantID = contestantID;
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
