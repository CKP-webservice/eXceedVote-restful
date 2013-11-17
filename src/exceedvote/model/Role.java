package exceedvote.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Role {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String role;
	private int voteLimit;
	
	public Role()
	{
		
	}
	
	public Role(String role, int voteLimit)
	{
		this.setRole(role);
		this.setVoteLimit(voteLimit);
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getVoteLimit() {
		return voteLimit;
	}

	public void setVoteLimit(int voteLimit) {
		this.voteLimit = voteLimit;
	}
	
	public int getId() {
		return id;
	}
	
}
