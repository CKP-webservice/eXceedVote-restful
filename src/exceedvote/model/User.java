package exceedvote.model;

import javax.persistence.*;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String username;
	@SuppressWarnings("unused")
	private String password;
	private String name;
	private String lastName;
	private int roleId;
	private int projectId;
	
	public User()
	{
		
	}
	
	public User(String name, String lastName, String username, String password, int roleId, int projectId)
	{
		this.name = name;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.roleId = roleId;
		this.projectId = projectId;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getUsername() {
		return username;
	}
	
	public int getRoleId() {
		return roleId;
	}
	
	public void setRoleId(int id) {
		this.roleId = id;
	}
	
	public String getRole() {
		if(roleId == 1) return "admin";
		else if(roleId == 2) return "guest";
		else if(roleId == 3) return "staff";
		else return "student";
	}
	
	public int getId() {
		return id;
	}
	
	public int getProjectId() {
		return projectId;
	}
	
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
		
	}
	
}
