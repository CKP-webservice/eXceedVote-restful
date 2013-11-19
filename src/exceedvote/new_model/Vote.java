package exceedvote.new_model;

import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlRootElement;

import com.mongodb.BasicDBObject;

import java.util.Map;

@XmlRootElement
@Entity
public class Vote extends BasicDBObject {
	private static final long serialVersionUID = 1L;
	
	private int voteID;
	private int userID;
	private int criterionID;
	// contestant , score
	private Map<Integer,Integer> scoreMap;
	
	public Vote() {
		
	}
	
	public Vote(int voteID, int userID, int criterionID) {
		put("voteID", voteID);
		put("userID", userID);
		put("criterionID", criterionID);
	}

	public int getVoteID() {
		return voteID;
	}

	public void setVoteID(int voteID) {
		this.voteID = voteID;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public int getCriterionID() {
		return criterionID;
	}

	public void setCriterionID(int criterionID) {
		this.criterionID = criterionID;
	}

	public Map<Integer, Integer> getScoreMap() {
		return scoreMap;
	}

	public void setScoreMap(Map<Integer, Integer> scoreMap) {
		this.scoreMap = scoreMap;
	}
}
