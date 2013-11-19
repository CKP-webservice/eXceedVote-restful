package exceedvote.model.dao.mongo;

import java.util.List;
import java.util.Set;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;

import exceedvote.model.dao.VoteDAO;
import exceedvote.new_model.Vote;

public class MongoVoteDAO {
	private DBCollection coll;
	
	public MongoVoteDAO(DB db) {
		this.coll = db.getCollection("vote");
		coll.setObjectClass(Vote.class);
	}
	
	public List<Vote> findAll() {
	    return null;
	}
	
	public Vote findById(int id) {
	    //Vote vote = new Vote(id);
	    //DBCursor c = coll.find(vote);
		return null;
	}
	
	public void save(Vote vote) {
		coll.save(vote);
	}
	
	public void delete(Vote vote) {
	    coll.save(vote);
	}
}
