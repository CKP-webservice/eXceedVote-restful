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
		List<Contestant> contestants = new ArrayList<Contestant>();
		DBCursor cursor = coll.find();
		Contestant contestant = null;
		try {
			while(cursor.hasNext()) {
				DBObject DBObj = cursor.next();
				Integer contestantID = (Integer) DBObj.get("contestantID");
				System.out.println(contestantID);
				String name = (String) DBObj.get("name");
				System.out.println(name);
				String description = (String) DBObj.get("description");
				System.out.println(description);
				contestant = new Contestant(contestantID, name, description);
				contestants.add(contestant);
			}
		} finally {
		   cursor.close();
		}
		return contestants;
	}
	
	public Contestant findById(int id) {
		BasicDBObject query = new BasicDBObject("contestantID", id);
		DBCursor cursor = coll.find(query);
		Contestant contestant = null;
		try {
			DBObject DBObj = cursor.next();
			Integer contestantID = (Integer) DBObj.get("contestantID");
			System.out.println(contestantID);
			String name = (String) DBObj.get("name");
			System.out.println(name);
			String description = (String) DBObj.get("description");
			System.out.println(description);
			contestant = new Contestant(contestantID, name, description);
		} finally {
		   cursor.close();
		}
		return contestant;
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
