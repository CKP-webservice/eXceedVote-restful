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
	
	public Rank() {
		//find all criteria
		List<Criterion> criteria = MongoDaoFactory.getInstance().getCriterionDAO().findAll();
		//find all contestant
		List<Contestant> contestants = MongoDaoFactory.getInstance().getContestantDAO().findAll();
		//init rank criteria (<criteria><criterion></criterion></criteria>)
		rankCriteria = new ArrayList<RankCriterion>();
		//search for all criterion
		for(Criterion criterion : criteria) {
			//new list rankscore (<contestants><contestant></contestant></contestants>)
			List<RankScore> rsAll = new ArrayList<RankScore>();
			//find vote by criterionID
			List<Vote> votes = MongoDaoFactory.getInstance().getVoteDAO().findByCriterionId(criterion.getCriterionID());
			//search all contestant for 1 criterion
			for(Contestant contestant : contestants) {
				//init sum value
				int sum = 0;
				//search all vote by criterionID
				for(Vote vote : votes) {
					//find score by voteID, criterionID
					List<Ballot> ballots = MongoDaoFactory.getInstance().getBallotDAO().findByVoteAndContestantId(vote.getVoteID(), contestant.getContestantID());
					for(Ballot ballot : ballots) {
						sum += ballot.getScore();
					}	
				}
				RankScore rankScore = new RankScore(contestant.getContestantID(), contestant.getName(), sum);
				rsAll.add(rankScore);
			}
			//new rank criterion (<criterion><contestants><contestant></contestant></contestants></criterion>)
			RankCriterion rc = new RankCriterion(criterion.getCriterionID(), criterion.getName() ,rsAll);
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
