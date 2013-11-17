package exceedvote.model;

import java.util.Date;

import javax.persistence.*;

@Entity
public class Vote {
	private int questionID;
	private int projectID;
	private int userID;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Temporal(TemporalType.TIMESTAMP)
	private Date timestampField;
	
	public Vote()
	{
		
	}
	public Vote(int questionID, int projectID, int userID)
	{
		this.questionID = questionID;
		this.projectID = projectID;
		this.userID = userID;
		this.timestampField = new Date();
	}
	
	public void setQuestionID(int id)
	{
		this.questionID = id;
	}
	
	public int getQuestionID()
	{
		return questionID;
	}
	
	public void setProjectID(int id)
	{
		this.projectID = id;
	}
	
	public int getProjectID()
	{
		return projectID;
	}
	
	public void setUserID(int id)
	{
		this.userID = id;
	}
	
	public int getUserID()
	{
		return userID;
	}
	
	public Date getTimestampField() {
		return timestampField;
	}
	
	public int getId() {
		return id;
	}
}
