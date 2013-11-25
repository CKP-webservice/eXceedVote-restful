package exceedvote.new_model;

import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="contestant")
@Entity
public class Contestant {
	private long contestantId;
	private String name;
	private String description;
}
