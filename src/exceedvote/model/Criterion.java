package exceedvote.model;

import java.io.IOException;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.mongodb.BasicDBObject;

import exceedvote.helper.MongoHelper;

@XmlRootElement(name="criterion")
@XmlAccessorType(XmlAccessType.FIELD)
public class Criterion extends BasicDBObject {
	private static final long serialVersionUID = 1L;
	@XmlElement(name="id")
	private int criterionID;
	@XmlElement(name="question")
	private String name;
	
	public Criterion() {
		
	}
	
	public Criterion(String name) {
		try {
			criterionID = Integer.parseInt(MongoHelper.getNextId("criterionID"));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		put("criterionID", criterionID);
		put("name", name);
	}

	public Criterion(int criterionID, String name) {
		this.criterionID = criterionID;
		this.name = name;
	}

	public int getCriterionID() {
		return criterionID;
	}

	public void setCriterionID(int criterionID) {
		this.criterionID = criterionID;
		put("criterionID", criterionID);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		put("name", name);
	}
}
