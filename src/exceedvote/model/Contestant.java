package exceedvote.model;

import java.io.IOException;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.mongodb.BasicDBObject;

import exceedvote.helper.MongoHelper;


@XmlRootElement(name="contestant")
public class Contestant extends BasicDBObject {
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private String description;
	
	public Contestant() {
		
	}
	
	public Contestant(String name, String description) {
		try {
			id = Integer.parseInt(MongoHelper.getNextId("contestantID"));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		put("contestantID", id);
		put("name", name);
		put("description", description);
	}
	
	public Contestant(int id, String name, String description) {
		this.id = id;
		this.name = name;
		this.description = description;
	}

	public int getContestantID() {
		return id;
	}

	public void setContestantID(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
