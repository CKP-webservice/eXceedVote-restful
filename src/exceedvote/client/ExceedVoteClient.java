package exceedvote.client;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.filter.HTTPDigestAuthFilter;

import exceedvote.model.Contestant;
import exceedvote.model.dao.mongo.MongoContestantDAO;
import exceedvote.model.dao.mongo.MongoDaoFactory;
 
public class ExceedVoteClient {
 
	public static void main(String[] args) {
		/*try {
		 
		Client client = Client.create();
		//client.addFilter(new HTTPDigestAuthFilter("chanon", "gg"));
		
		WebResource webResource = client
		   .resource("http://localhost:8080/project");
 
 
		ClientResponse response = webResource.accept("application/xml")
		   .get(ClientResponse.class);
 
		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
			     + response.getStatus());
		}
 
		System.out.println("Output from Server .... \n");
		String output = response.getEntity(String.class);
		System.out.println(output);
 
	  } catch (Exception e) {
 
		e.printStackTrace();
 
	  }
 
	}*/
		Contestant con = new Contestant("test", "ggwp");
		Contestant con2 = new Contestant("test2", "ggwp2");
		try {
			MongoContestantDAO contestantDAO = MongoDaoFactory.getInstance().getContestantDAO();
			contestantDAO.save(con);
			contestantDAO.save(con2);
			Contestant con3 = contestantDAO.findById(1);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
}