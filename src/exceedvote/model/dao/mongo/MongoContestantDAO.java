package exceedvote.model.dao.mongo;

import java.util.ArrayList;
import java.util.List;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;

import exceedvote.new_model.Contestant;

public class MongoContestantDAO {
	private DBCollection coll;
	
	public MongoContestantDAO(DB db) {
		this.coll = db.getCollection("contestant");
		coll.setObjectClass(Contestant.class);
	}
	
	public List<Contestant> findAll() {
		List<Contestant> contestants = new ArrayList<Contestant>();
		DBCursor cursorDoc = coll.find();
        while(cursorDoc.hasNext()) {
        	Contestant contestant = (Contestant)cursorDoc.next();
        	contestants.add(contestant);
        }
	    return contestants;
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
