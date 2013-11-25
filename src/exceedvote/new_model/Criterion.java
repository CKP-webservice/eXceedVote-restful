package exceedvote.new_model;

import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="criterion")
@Entity
public class Criterion {
	private long criterionID;
	private String name;
}
