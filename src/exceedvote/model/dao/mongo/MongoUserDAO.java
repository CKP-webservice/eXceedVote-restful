package exceedvote.model.dao.mongo;

import java.util.List;
import java.util.Set;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;

import exceedvote.model.dao.VoteDAO;
import exceedvote.new_model.Criterion;
import exceedvote.new_model.User;

public class MongoUserDAO {
	private DBCollection coll;
	
	public MongoUserDAO(DB db) {
		this.coll = db.getCollection("user");
		coll.setObjectClass(User.class);
	}
	
	public List<User> findAll() {
	    return null;
	}
	
	public User findById(int id) {
	    //User user = new User(id);
	    //DBCursor c = coll.find(user);
		return null;
	}
	
	public void save(User user) {
		coll.save(user);
	}
	
	public void delete(User user) {
	    coll.remove(user);
	}
}
