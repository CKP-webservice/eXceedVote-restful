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

import exceedvote.new_model.Criterion;
import exceedvote.new_model.Role;

public class MongoRoleDAO {
	private DBCollection coll;
	
	public MongoRoleDAO(DB db) {
		this.coll = db.getCollection("role");
		coll.setObjectClass(Role.class);
	}
	
	public List<Role> findAll() {
		List<Role> roles = new ArrayList<Role>();
		DBCursor cursor = coll.find();
		Role role = null;
		try {
			while(cursor.hasNext()) {
				DBObject DBObj = cursor.next();
				Integer roleID = (Integer) DBObj.get("roleID");
				String name = (String) DBObj.get("name");
				Integer criterionVote = (Integer) DBObj.get("criterionVote");
				role = new Role(roleID, name, criterionVote);
				roles.add(role);
			}
		} finally {
		   cursor.close();
		}
		return roles;
	}
	
	public Role findById(int id) {
		BasicDBObject query = new BasicDBObject("roleID", id);
		DBCursor cursor = coll.find(query);
		Role role = null;
		try {
			DBObject DBObj = cursor.next();
			Integer roleID = (Integer) DBObj.get("roleID");
			String name = (String) DBObj.get("name");
			Integer criterionVote = (Integer) DBObj.get("criterionVote");
			role = new Role(roleID, name, criterionVote);
		} finally {
		   cursor.close();
		}
		return role;
	}
	
	public void save(Role role) {
	    coll.save(role);
	}
	
	public void delete(Role role) {
	    coll.save(role);
	}
}
