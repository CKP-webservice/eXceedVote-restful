package exceedvote.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="myvote")
public class VoteList {
	
	@XmlElementWrapper(name="votes")
	List<Vote> voteList;
	
	public VoteList() {
		this.voteList = new ArrayList<Vote>();
	}
	
	public void add(Vote vote) {
		this.voteList.add(vote);
	}
}
