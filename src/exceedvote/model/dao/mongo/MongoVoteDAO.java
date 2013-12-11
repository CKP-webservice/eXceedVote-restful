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

import exceedvote.model.Criterion;
import exceedvote.model.User;
import exceedvote.model.Vote;

public class MongoVoteDAO {
	private DBCollection coll;
	
	public MongoVoteDAO(DB db) {
		this.coll = db.getCollection("vote");
		coll.setObjectClass(Vote.class);
	}
	
	public List<Vote> findAll() {
		List<Vote> votes = new ArrayList<Vote>();
		DBCursor cursor = coll.find();
		Vote vote = null;
		try {
			while(cursor.hasNext()) {
				DBObject DBObj = cursor.next();
				Integer voteID = (Integer) DBObj.get("voteID");
				MongoUserDAO userDAO = MongoDaoFactory.getInstance().getUserDAO();
				MongoCriterionDAO criterionDAO = MongoDaoFactory.getInstance().getCriterionDAO();
				Integer userID = (Integer) DBObj.get("userID");
				User user = userDAO.findById(userID);
				Integer criterionID = (Integer) DBObj.get("criterionID");
				Criterion criterion = criterionDAO.findById(criterionID);
				vote = new Vote(voteID, user, criterion);
				votes.add(vote);
			}
		} finally {
		   cursor.close();
		}
		return votes;
	}
	
	public Vote findById(int id) {
		BasicDBObject query = new BasicDBObject("voteID", id);
		DBCursor cursor = coll.find(query);
		Vote vote = null;
		try {
			DBObject DBObj = cursor.next();
			Integer voteID = (Integer) DBObj.get("voteID");
			MongoUserDAO userDAO = MongoDaoFactory.getInstance().getUserDAO();
			MongoCriterionDAO criterionDAO = MongoDaoFactory.getInstance().getCriterionDAO();
			Integer userID = (Integer) DBObj.get("userID");
			User user = userDAO.findById(userID);
			Integer criterionID = (Integer) DBObj.get("criterionID");
			Criterion criterion = criterionDAO.findById(criterionID);
			vote = new Vote(voteID, user, criterion);
		} finally {
		   cursor.close();
		}
		return vote;
	}
	
	public List<Vote> findByUserId(int id) {
		System.out.println("!!!");
		List<Vote> votes = new ArrayList<Vote>();
		BasicDBObject query = new BasicDBObject("userID", id);
		DBCursor cursor = coll.find(query);
		Vote vote = null;
		try {
			while(cursor.hasNext()) {
				DBObject DBObj = cursor.next();
				Integer voteID = (Integer) DBObj.get("voteID");
				MongoUserDAO userDAO = MongoDaoFactory.getInstance().getUserDAO();
				MongoCriterionDAO criterionDAO = MongoDaoFactory.getInstance().getCriterionDAO();
				Integer userID = (Integer) DBObj.get("userID");
				User user = userDAO.findById(userID);
				Integer criterionID = (Integer) DBObj.get("criterionID");
				Criterion criterion = criterionDAO.findById(criterionID);
				vote = new Vote(voteID, user, criterion);
				votes.add(vote);
			}
		} finally {
		   cursor.close();
		}
		return votes;
	}
	
	
	public void save(Vote vote) {
		coll.save(vote);
	}
	
	public void delete(Vote vote) {
	    coll.save(vote);
	}
}
