package exceedvote.model.dao.mongo;

import java.util.List;
import java.util.Set;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;

import exceedvote.model.dao.VoteDAO;
import exceedvote.new_model.Criterion;
import exceedvote.new_model.Role;

public class MongoRoleDAO {
	private DBCollection coll;
	
	public MongoRoleDAO(DB db) {
		this.coll = db.getCollection("role");
		coll.setObjectClass(Role.class);
	}
	
	public List<Role> findAll() {
	    return null;
	}
	
	public Role findById(int id) {
	    //Role role = new Role(id);
	    //DBCursor c = coll.find(role);
		return null;
	}
	
	public void save(Role role) {
	    
	}
	
	public void delete(Role role) {
	    
	}
}
