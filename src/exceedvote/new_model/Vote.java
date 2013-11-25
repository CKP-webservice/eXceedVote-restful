package exceedvote.new_model;

import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Map;

@XmlRootElement
@Entity
public class Vote {
	private long voteID;
	private long userID;
	private long  criterionID;
	// contestant , score
	private Map<Long,Integer> map;
}
