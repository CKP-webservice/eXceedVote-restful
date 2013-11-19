package exceedvote.model.dao.mongo;

import java.util.List;
import java.util.Set;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;

import exceedvote.model.dao.VoteDAO;
import exceedvote.new_model.Criterion;

public class MongoCriterionDAO {
	private DBCollection coll;
	
	public MongoCriterionDAO(DB db) {
		this.coll = db.getCollection("criterion");
		coll.setObjectClass(Criterion.class);
	}
	
	public List<Criterion> findAll() {
	    return null;
	}
	
	public Criterion findById(int id) {
	    //Criterion criterion = new Criterion(id);
	    //DBCursor c = coll.find(criterion);
		return null;
	}
	
	public void save(Criterion criterion) {
	    coll.save(criterion);
	}
	
	public void delete(Criterion criterion) {
		coll.remove(criterion);
	}
}
