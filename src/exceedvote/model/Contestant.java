package exceedvote.model;

import java.io.IOException;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import com.mongodb.BasicDBObject;

import exceedvote.helper.MongoHelper;


@XmlRootElement(name="contestant")
@XmlAccessorType(XmlAccessType.FIELD)
public class Contestant extends BasicDBObject {
	private static final long serialVersionUID = 1L;
	@XmlElement(name="id")
	private int contestantID;
	private String name;
	private String description;
	
	public Contestant() {
		
	}
	
	public Contestant(String name, String description) {
		try {
			contestantID = Integer.parseInt(MongoHelper.getNextId("contestantID"));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		put("contestantID", contestantID);
		put("name", name);
		put("description", description);
		this.name = name;
		this.description = description;
	}
	
	public Contestant(int contestantID, String name, String description) {
		this.contestantID = contestantID;
		this.name = name;
		this.description = description;
	}

	public int getContestantID() {
		return contestantID;
	}

	public void setContestantID(int contestantID) {
		this.contestantID = contestantID;
		put("contestantID", contestantID);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		put("name", name);
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
		put("description", description);
	}
}
