package exceedvote.new_model;

import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
public class Role {
	private long roleID;
	private String name;
	private int critirionVote;
}
