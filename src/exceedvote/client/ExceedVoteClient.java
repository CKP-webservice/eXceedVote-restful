package exceedvote.client;
import java.util.ArrayList;
import java.util.List;

import exceedvote.model.Ballot;
import exceedvote.model.Contestant;
import exceedvote.model.Criterion;
import exceedvote.model.Role;
import exceedvote.model.User;
import exceedvote.model.Vote;
import exceedvote.model.dao.mongo.MongoContestantDAO;
import exceedvote.model.dao.mongo.MongoCriterionDAO;
import exceedvote.model.dao.mongo.MongoDaoFactory;
import exceedvote.model.dao.mongo.MongoUserDAO;
import exceedvote.model.dao.mongo.MongoVoteDAO;
 
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
		Criterion cri = new Criterion("lol");
		MongoContestantDAO contestantDAO = MongoDaoFactory.getInstance().getContestantDAO();
		MongoCriterionDAO criterionDAO = MongoDaoFactory.getInstance().getCriterionDAO();
		criterionDAO.save(cri);
		contestantDAO.save(con);
		Ballot ballot = new Ballot(1, 1);
		List<Ballot> ballots = new ArrayList<Ballot>();
		ballots.add(ballot);
		Role role = new Role("name", 5);
		User user = new User(role, con, "username", "password", "email");
		MongoUserDAO userDAO = MongoDaoFactory.getInstance().getUserDAO();
		MongoVoteDAO voteDAO = MongoDaoFactory.getInstance().getVoteDAO();
		Vote vote = new Vote(user, cri, ballots);
		userDAO.save(user);
		voteDAO.save(vote);
	}	
}