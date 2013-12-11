package exceedvote.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import exceedvote.model.dao.mongo.MongoDaoFactory;

@XmlRootElement(name="rank")
@XmlAccessorType(XmlAccessType.FIELD)
public class Rank {
	@XmlElementWrapper(name="criteria")
	@XmlElement(name="criterion")
	private List<RankCriterion> rankCriteria;
	
	public Rank(int userID) {
		List<Vote> votes = MongoDaoFactory.getInstance().getVoteDAO().findByUserId(userID);
		rankCriteria = new ArrayList<RankCriterion>();
		for(Vote vote : votes) {
			RankCriterion rc = new RankCriterion();
			List<RankScore> rsAll = new ArrayList<RankScore>();
			List<Ballot> ballots = MongoDaoFactory.getInstance().getBallotDAO().findByVoteId(vote.getVoteID());
			for(Ballot ballot : ballots) {
				//TODO sum for find total score
//				Contestant contestant = MongoDaoFactory.getInstance().getContestantDAO().findById(ballot.getContestant());
//				RankScore rs = new RankScore(ballot.getContestant(), contestant.getName(), ballot.getScore());
//				rsAll.add(rs);
			}
			rankCriteria.add(rc);
		}
	}

	public List<RankCriterion> getRankCriteria() {
		return rankCriteria;
	}

	public void setRankCriteria(List<RankCriterion> rankCriteria) {
		this.rankCriteria = rankCriteria;
	}	
}
