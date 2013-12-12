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
	@XmlElement(name="name")
	private int criterionID;
	@XmlElement(name="question")
	private String name;
	@XmlElementWrapper(name="contestants")
	@XmlElement(name="contestant")
	private List<RankScore> rankScores;
	
	public RankCriterion() {
		
	}
	
	public RankCriterion(int criterionID, String name, List<RankScore> rankScores) {
		this.criterionID = criterionID;
		this.name = name;
		this.rankScores = rankScores;
	}

	public int getCriterionID() {
		return criterionID;
	}

	public void setCriterionID(int criterionID) {
		this.criterionID = criterionID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
