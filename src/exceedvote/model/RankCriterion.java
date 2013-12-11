package exceedvote.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;

@XmlRootElement(name="criterion")
@XmlAccessorType(XmlAccessType.FIELD)
public class RankCriterion {
	@XmlElementWrapper(name="contestants")
	@XmlElement(name="contestant")
	private List<RankScore> rankScores;
	
	public RankCriterion() {
		
	}
	
	public RankCriterion(List<RankScore> rankScores) {
		this.rankScores = rankScores;
	}

	public List<RankScore> getrankScores() {
		return rankScores;
	}

	public void setrankScores(List<RankScore> rankScores) {
		this.rankScores = rankScores;
	}
	
	public void add(RankScore rankScore) {
		this.rankScores.add(rankScore);
	}
}
