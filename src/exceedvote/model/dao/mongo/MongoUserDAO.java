package exceedvote.model.dao.mongo;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

import exceedvote.model.Contestant;
import exceedvote.model.Criterion;
import exceedvote.model.Role;
import exceedvote.model.User;

public class MongoUserDAO {
	private DBCollection coll;
	
	public MongoUserDAO(DB db) {
		this.coll = db.getCollection("user");
		coll.setObjectClass(User.class);
	}
	
	public List<User> findAll() {
		List<User> users = new ArrayList<User>();
		DBCursor cursor = coll.find();
		User user = null;
		try {
			while(cursor.hasNext()) {
				DBObject DBObj = cursor.next();
				Integer userID = (Integer) DBObj.get("userID");
				Integer roleID = (Integer) DBObj.get("roleID");
				MongoRoleDAO roleDAO = MongoDaoFactory.getInstance().getRoleDAO();
				MongoContestantDAO contestantDAO = MongoDaoFactory.getInstance().getContestantDAO();
				Role role = roleDAO.findById(roleID); 
				Integer contestantID = (Integer) DBObj.get("contestantID");
				Contestant contestant = contestantDAO.findById(contestantID);
				String username = (String) DBObj.get("username");
				String password = (String) DBObj.get("password");
				String email = (String) DBObj.get("email");
				user = new User(userID, role, contestant, username, password, email);
				users.add(user);
			}
		} finally {
		   cursor.close();
		}
		return users;
	}
	
	public User findById(int id) {
		BasicDBObject query = new BasicDBObject("userID", id);
		DBCursor cursor = coll.find(query);
		User user = null;
		try {
			DBObject DBObj = cursor.next();
			Integer userID = (Integer) DBObj.get("userID");
			Integer roleID = (Integer) DBObj.get("roleID");
			MongoRoleDAO roleDAO = MongoDaoFactory.getInstance().getRoleDAO();
			MongoContestantDAO contestantDAO = MongoDaoFactory.getInstance().getContestantDAO();
			Role role = roleDAO.findById(roleID); 
			Integer contestantID = (Integer) DBObj.get("contestantID");
			Contestant contestant = contestantDAO.findById(contestantID);
			String username = (String) DBObj.get("username");
			String password = (String) DBObj.get("password");
			String email = (String) DBObj.get("email");
			user = new User(userID, role, contestant, username, password, email);
		} finally {
		   cursor.close();
		}
		return user;
	}
	
	public void save(User user) {
		coll.save(user);
	}
	
	public void delete(User user) {
	    coll.remove(user);
	}
}
