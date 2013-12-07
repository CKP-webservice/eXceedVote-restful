package exceedvote.model;

import java.io.IOException;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.mongodb.BasicDBObject;

import exceedvote.helper.MongoHelper;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class User extends BasicDBObject {
	private static final long serialVersionUID = 1L;
	
	@XmlElement(name="id")
	private int userID;
	private Role role;
	private Contestant contestant;
	private String username;
	private String password;
	private String email;
	
	public User() {
		
	}
	
	public User(Role role, Contestant contestant, String username, String password, String email) {
		try {
			userID = Integer.parseInt(MongoHelper.getNextId("userID"));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		put("userID", userID);
		put("roleID", role.getRoleID());
		put("contestantID", contestant.getContestantID());
		put("username", username);
		put("password", password);
		put("email", email);
	}

	public User(int userID, Role role, Contestant contestant, String username, String password, String email) {
		this.userID = userID;
		this.role = role;
		this.contestant = contestant;
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

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Contestant getContestant() {
		return contestant;
	}

	public void setContestant(Contestant contestant) {
		this.contestant = contestant;
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
