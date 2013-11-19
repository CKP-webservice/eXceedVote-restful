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

public class MongoCriterionDAO {
	private DBCollection coll;
	
	public MongoCriterionDAO(DB db) {
		this.coll = db.getCollection("criterion");
		coll.setObjectClass(Criterion.class);
	}
	
	public List<Criterion> findAll() {
		List<Criterion> criteria = new ArrayList<Criterion>();
		DBCursor cursor = coll.find();
		Criterion criterion = null;
		try {
			while(cursor.hasNext()) {
				DBObject DBObj = cursor.next();
				Integer criterionID = (Integer) DBObj.get("criterionID");
				String name = (String) DBObj.get("name");
				criterion = new Criterion(criterionID, name);
				criteria.add(criterion);
			}
		} finally {
		   cursor.close();
		}
		return criteria;
	}
	
	public Criterion findById(int id) {
		BasicDBObject query = new BasicDBObject("criterionID", id);
		DBCursor cursor = coll.find(query);
		Criterion criterion = null;
		try {
			DBObject DBObj = cursor.next();
			Integer criterionID = (Integer) DBObj.get("criterionID");
			String name = (String) DBObj.get("name");
			criterion = new Criterion(criterionID, name);
		} finally {
		   cursor.close();
		}
		return criterion;
	}
	
	public void save(Criterion criterion) {
	    coll.save(criterion);
	}
	
	public void delete(Criterion criterion) {
		coll.remove(criterion);
	}
}
