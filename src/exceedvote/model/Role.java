package exceedvote.model;

import java.io.IOException;

import javax.xml.bind.annotation.XmlRootElement;

import com.mongodb.BasicDBObject;

import exceedvote.helper.MongoHelper;

@XmlRootElement
public class Role extends BasicDBObject {
	private static final long serialVersionUID = 1L;
	
	private int roleID;
	private String name;
	private int criterionVote;
	
	public Role() {
		
	}
	
	public Role(String name, int criterionVote) {
		try {
			roleID = Integer.parseInt(MongoHelper.getNextId("roleID"));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		put("roleID", roleID);
		put("name", name);
		put("criterionVote", criterionVote);
		this.name = name;
		this.criterionVote = criterionVote;
	}

	public Role(int roleID, String name, int criterionVote) {
		super();
		this.roleID = roleID;
		this.name = name;
		this.criterionVote = criterionVote;
	}

	public int getRoleID() {
		return roleID;
	}

	public void setRoleID(int roleID) {
		this.roleID = roleID;
		put("roleID", roleID);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		put("name", name);
	}

	public int getCriterionVote() {
		return criterionVote;
	}

	public void setCriterionVote(int criterionVote) {
		this.criterionVote = criterionVote;
		put("criterionVote", criterionVote);
	}
}
