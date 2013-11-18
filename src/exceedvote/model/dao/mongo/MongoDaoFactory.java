package exceedvote.model.dao.mongo;

import java.net.UnknownHostException;

import com.mongodb.DB;
import com.mongodb.MongoClient;

public class MongoDaoFactory {
	private DB db;
	
	public MongoDaoFactory() throws UnknownHostException {
		MongoClient mongoClient = new MongoClient( "ds053428.mongolab.com", 53428);
		db = mongoClient.getDB("exceedvote");
		char[] pass = {'c', 'k', 'p', 'e', 'x', 'c', 'e', 'e', 'd', 'v', 'o', 't', 'e'};
		boolean auth = db.authenticate("exceedvote", pass);
	}
}
