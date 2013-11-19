package exceedvote.new_model;

import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlRootElement;

import com.mongodb.BasicDBObject;

@XmlRootElement
@Entity
public class Role extends BasicDBObject {
	private static final long serialVersionUID = 1L;
	
	private int roleID;
	private String name;
	private int criterionVote;
	
	public Role() {
		
	}
	
	public Role(int roleID, String name, int criterionVote) {
		put("roleID", roleID);
		put("name", name);
		put("criterionVote", criterionVote);
	}

	public int getRoleID() {
		return roleID;
	}

	public void setRoleID(int roleID) {
		this.roleID = roleID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCriterionVote() {
		return criterionVote;
	}

	public void setCriterionVote(int criterionVote) {
		this.criterionVote = criterionVote;
	}
}
