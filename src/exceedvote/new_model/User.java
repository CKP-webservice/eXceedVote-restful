package exceedvote.new_model;

import java.io.IOException;

import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlRootElement;

import com.mongodb.BasicDBObject;

import exceedvote.helper.MongoHelper;

@XmlRootElement
@Entity
public class User extends BasicDBObject {
	private static final long serialVersionUID = 1L;
	
	private int userID;
	private int roleID;
	private int contestantID;
	private String username;
	private String password;
	private String email;
	
	public User() {
		
	}
	
	public User(int roleID, int contestantID, String username, String password, String email) {
		try {
			userID = Integer.parseInt(MongoHelper.getNextId("userID"));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		put("userID", userID);
		put("roleID", roleID);
		put("contestantID", contestantID);
		put("username", username);
		put("password", password);
		put("email", email);
	}

	public User(int userID, int roleID, int contestantID, String username, String password, String email) {
		this.userID = userID;
		this.roleID = roleID;
		this.contestantID = contestantID;
		this.username = username;
		this.password = password;
		this.email = email;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public int getRoleID() {
		return roleID;
	}

	public void setRoleID(int roleID) {
		this.roleID = roleID;
	}

	public int getContestantID() {
		return contestantID;
	}

	public void setContestantID(int contestantID) {
		this.contestantID = contestantID;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
