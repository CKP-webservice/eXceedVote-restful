package exceedvote.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;



@XmlRootElement(name="contestants")
@XmlAccessorType(XmlAccessType.FIELD)
public class ContestantList {
	@XmlElement(name="contestant")
	private List<Contestant> contestantList;

	public ContestantList() {
		contestantList = new ArrayList<Contestant>();
	}

	public void setContestantList(List<Contestant> contestantList) {
		this.contestantList = contestantList;
	}

	public List<Contestant> getContestantList() {
		return contestantList;
	}
	
	public void add(Contestant contestant) {
		this.contestantList.add(contestant);
	}
}
