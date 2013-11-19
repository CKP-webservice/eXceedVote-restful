package exceedvote.new_model;

import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlRootElement;

import com.mongodb.BasicDBObject;

@XmlRootElement(name="criterion")
@Entity
public class Criterion extends BasicDBObject {
	private static final long serialVersionUID = 1L;
	
	private int criterionID;
	private String name;
	
	public Criterion() {
		
	}
	
	public Criterion(int criterionID, String name) {
		put("criterionID", criterionID);
		put("name", name);
	}

	public int getCriterionID() {
		return criterionID;
	}

	public void setCriterionID(int criterionID) {
		this.criterionID = criterionID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
