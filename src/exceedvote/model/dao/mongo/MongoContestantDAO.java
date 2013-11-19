package exceedvote.model.dao.mongo;

import java.util.ArrayList;
import java.util.List;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

import exceedvote.new_model.Contestant;

public class MongoContestantDAO {
	private DBCollection coll;
	
	public MongoContestantDAO(DB db) {
		this.coll = db.getCollection("contestant");
		coll.setObjectClass(Contestant.class);
	}
	
	public List<Contestant> findAll() {
		return null;
	}
	
	public Contestant findById(int id) {
	    return null;
	}
	
	public DBCollection getCollection() {
		return coll;
	}
	
	public void save(Contestant contestant) {
	    coll.save(contestant);
	}
	
	public void delete(Contestant contestant) {
	    coll.remove(contestant);
	}
}
