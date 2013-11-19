package exceedvote.model.dao.mongo;

import java.util.List;
import java.util.Set;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;

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
	    //Contestant contestant = new Contestant(id);
	    //DBCursor c = coll.find(contestant);
	    return null;
	}
	
	public void save(Contestant contestant) {
	    
	}
	
	public void delete(Contestant contestant) {
	    
	}
}
