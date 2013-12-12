package exceedvote.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="myvote")
@XmlAccessorType(XmlAccessType.FIELD)
public class VoteList {
	
	@XmlElementWrapper(name="votes")
	@XmlElement(name="vote")
	private List<Vote> voteList;
	
	public VoteList() {
		this.setVoteList(new ArrayList<Vote>());
	}
	
	public void add(Vote vote) {
		this.getVoteList().add(vote);
	}

	public List<Vote> getVoteList() {
		return voteList;
	}

	public void setVoteList(List<Vote> voteList) {
		this.voteList = voteList;
	}
	
	
}
