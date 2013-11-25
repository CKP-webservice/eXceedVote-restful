package exceedvote.new_model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="contestant")
@Entity
public class ContestantList {
	List<Contestant> contestantList;
	
	public ContestantList() {
		contestantList = new ArrayList<Contestant>();
	}
}
