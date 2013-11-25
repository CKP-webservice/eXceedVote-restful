package exceedvote.new_model;

import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
public class User {
	private long UserID;
	private long roleID;
	private long contestantID;
	private String username;
	private String password;
	private String email;	
}
