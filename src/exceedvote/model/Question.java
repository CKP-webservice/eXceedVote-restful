package exceedvote.model;

import javax.persistence.*;

/**
 * Model from Question
 * @author Kanin Sirisith
 *
 */
@Entity
public class Question {
	private String title;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	/**
	 * Constructor for Question class
	 * @param question
	 */
	public Question()
	{
		
	}
	
	public Question(String title) {
		this.setTitle(title);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getId() {
		return this.id;
	}

}
