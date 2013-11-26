package exceedvote.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "contestants")
@Entity
public class ContestantList {
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
}
