package exceedvote.model.dao.mongo;

import java.io.IOException;
import java.net.UnknownHostException;

import com.mongodb.DB;
import com.mongodb.MongoClient;

public class MongoDaoFactory {
	private DB db;
	
	private MongoVoteDAO voteDAO;
	private MongoContestantDAO contestantDAO;
	private MongoCriterionDAO criterionDAO;
	private MongoUserDAO userDAO;
	private MongoRoleDAO roleDAO;
	private MongoBallotDAO ballotDAO;
	
	private static MongoDaoFactory daoFactory;
	public static MongoDaoFactory getInstance()
	{
		if(daoFactory == null) daoFactory = new MongoDaoFactory();
		return daoFactory;
	}
	
	public MongoDaoFactory() {
		MongoClient mongoClient = null;
		try {
			mongoClient = new MongoClient( "ds053428.mongolab.com", 53428);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		db = mongoClient.getDB("exceedvote");
		char[] pass = {'c', 'k', 'p', 'e', 'x', 'c', 'e', 'e', 'd', 'v', 'o', 't', 'e'};
		boolean auth = db.authenticate("exceedvote", pass);
	}
	
	public MongoVoteDAO getVoteDAO() {
	    if(this.voteDAO == null) this.voteDAO = new MongoVoteDAO(db);
	    return this.voteDAO;
	}
	
	public MongoContestantDAO getContestantDAO() {
		if(this.contestantDAO == null) this.contestantDAO = new MongoContestantDAO(db);
		return this.contestantDAO;
	}
	
	public MongoCriterionDAO getCriterionDAO() {
		if(this.criterionDAO == null) this.criterionDAO = new MongoCriterionDAO(db);
		return this.criterionDAO;
	}
	
	public MongoUserDAO getUserDAO() {
		if(this.userDAO == null) this.userDAO = new MongoUserDAO(db);
		return this.userDAO;
	}
	
	public MongoRoleDAO getRoleDAO() {
		if(this.roleDAO == null) this.roleDAO = new MongoRoleDAO(db);
		return this.roleDAO;
	}
	
	public MongoBallotDAO getBallotDAO() {
		if(this.ballotDAO == null) this.ballotDAO = new MongoBallotDAO(db);
		return this.ballotDAO;
	}
	
	public DB getDB() {
		return db;
	}
}

