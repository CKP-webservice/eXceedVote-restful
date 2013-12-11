package exceedvote.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.mongodb.BasicDBObject;

import exceedvote.helper.MongoHelper;

import java.io.IOException;
import java.util.List;

@XmlRootElement(name="vote")
@XmlAccessorType(XmlAccessType.FIELD)
public class Vote extends BasicDBObject {
	private static final long serialVersionUID = 1L;
	@XmlElement(name="id")
	private int voteID;
	private User user;
	private Criterion criterion;
	
	// contestant , score
	@XmlElement(name="contestants")
	private List<Ballot> ballots;
	
	public Vote() {
		
	}
	
	public Vote(User user, Criterion criterion) {
		try {
			voteID = Integer.parseInt(MongoHelper.getNextId("voteID"));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		put("voteID", voteID);
		put("userID", user.getUserID());
		put("criterionID", criterion.getCriterionID());
		this.user = user;
		this.criterion = criterion;
	}

	public Vote(int voteID, User user, Criterion criterion) {
		this.voteID = voteID;
		this.user = user;
		this.criterion = criterion;
	}

	public int getVoteID() {
		return voteID;
	}

	public void setVoteID(int voteID) {
		this.voteID = voteID;
		put("voteID", voteID);
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
		put("userID", user.getUserID());
	}

	public Criterion getCriterion() {
		return criterion;
	}

	public void setCriterion(Criterion criterion) {
		this.criterion = criterion;
		put("criterionID", criterion.getCriterionID());
	}

	public List<Ballot> getBallots() {
		return this.ballots;
	}

	public void setBallots(List<Ballot> ballots) {
		this.ballots = ballots;
	}
	
	public void addBallot(Ballot ballot) {
		this.ballots.add(ballot);
	}
}
