package exceedvote.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.mongodb.BasicDBObject;


@XmlRootElement(name="contestant")
@XmlAccessorType(XmlAccessType.FIELD)
public class Ballot extends BasicDBObject {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@XmlElement
	private int contestantID;
	@XmlElement
	private int score;
	
	public Ballot() {
		
	}
	
	public Ballot(int contestantID, int score, int voteID) {
		super();
		put("contestantID", contestantID);
		put("score", score);
		put("voteID", voteID);
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
		put("contestantID", contestant);
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
		put("score", score);
	}
}
