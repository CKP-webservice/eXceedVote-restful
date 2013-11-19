package exceedvote.new_model;

import java.util.Map;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
public class VoteResult {
	private long criterionID;
	// contestantID , sumScore
	private Map<Long, Integer> voteResult;
	
}
