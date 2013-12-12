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

import exceedvote.model.Ballot;
import exceedvote.model.Contestant;
import exceedvote.model.Vote;

public class MongoBallotDAO {
	private DBCollection coll;
	
	public MongoBallotDAO(DB db) {
		this.coll = db.getCollection("ballot");
		coll.setObjectClass(Ballot.class);
	}
	
	public List<Ballot> findAll() {
		List<Ballot> ballots = new ArrayList<Ballot>();
		DBCursor cursor = coll.find();
		Ballot ballot = null;
		try {
			while(cursor.hasNext()) {
				DBObject DBObj = cursor.next();
				Integer voteID = (Integer) DBObj.get("voteID");
				Integer contestantID = (Integer) DBObj.get("contestantID");
				Integer score = (Integer) DBObj.get("score");
				ballot = new Ballot(contestantID, score, voteID);
				ballots.add(ballot);
			}
		} finally {
		   cursor.close();
		}
		return ballots;
	}
	
	public List<Ballot> findByVoteId(int id) {
		List<Ballot> ballots = new ArrayList<Ballot>();
		BasicDBObject query = new BasicDBObject("voteID", id);
		DBCursor cursor = coll.find(query);
		Ballot ballot = null;
		try {
			while(cursor.hasNext()) {
				DBObject DBObj = cursor.next();
				Integer voteID = (Integer) DBObj.get("voteID");
				Integer contestantID = (Integer) DBObj.get("contestantID");
				Integer score = (Integer) DBObj.get("score");
				ballot = new Ballot(contestantID, score, voteID);
				ballots.add(ballot);
			}
		} finally {
		   cursor.close();
		}
		return ballots;
	}
	
	public List<Ballot> findByVoteAndContestantId(int vID, int cID) {
		List<Ballot> ballots = new ArrayList<Ballot>();
		BasicDBObject query1 = new BasicDBObject("voteID", vID); 
		BasicDBObject query2 = new BasicDBObject("criterion", cID); 
		ArrayList<BasicDBObject> listQuery = new ArrayList<BasicDBObject>(); 
		listQuery.add(query1); 
		listQuery.add(query2); 
		BasicDBObject query = new BasicDBObject("$and", listQuery); 
		DBCursor cursor = coll.find(query);
		Ballot ballot = null;
		try {
			while(cursor.hasNext()) {
				DBObject DBObj = cursor.next();
				Integer voteID = (Integer) DBObj.get("voteID");
				Integer contestantID = (Integer) DBObj.get("contestantID");
				Integer score = (Integer) DBObj.get("score");
				ballot = new Ballot(contestantID, score, voteID);
				ballots.add(ballot);
			}
		} finally {
		   cursor.close();
		}
		return ballots;
	}
	
	public void save(Ballot ballot) {
		coll.save(ballot);
	}
	
	public void saveAll(List<Ballot> ballots) {
		for (Ballot ballot : ballots) {
			coll.save(ballot);
		}
	}
	
	public void delete(Ballot ballot) {
	    coll.save(ballot);
	}
}
