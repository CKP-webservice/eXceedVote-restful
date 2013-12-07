package exceedvote.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.mongodb.BasicDBObject;


@XmlRootElement(name="contestant")
public class Ballot extends BasicDBObject {
	@XmlElement(name="id")
	private static final long serialVersionUID = 1L;
	private int contestantID;
	private int score;
	
	public Ballot() {
		
	}
	
	public Ballot(int contestantID, int score) {
		super();
		this.contestantID = contestantID;
		this.score = score;
	}
	
	/**
	 * @return the contestant
	 */
	public int getContestant() {
		return contestantID;
	}
	/**
	 * @param contestant the contestant to set
	 */
	public void setContestant(int contestant) {
		this.contestantID = contestant;
	}
	/**
	 * @return the score
	 */
	public int getScore() {
		return score;
	}
	/**
	 * @param score the score to set
	 */
	public void setScore(int score) {
		this.score = score;
	}
}
