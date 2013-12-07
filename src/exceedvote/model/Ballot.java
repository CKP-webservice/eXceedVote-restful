package exceedvote.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name="contestant")
public class Ballot {
	@XmlElement(name="id")
	private int contestantID;
	private int score;
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
