package exceedvote.resource;

import java.io.IOException;



import java.util.List;






//import javax.annotation.security.RolesAllowed;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import org.eclipse.persistence.descriptors.VPDMultitenantPolicy;

import com.sun.security.auth.UserPrincipal;

import exceedvote.model.Ballot;
import exceedvote.model.ContestantList;
import exceedvote.model.CriterionList;
import exceedvote.model.Rank;
import exceedvote.model.Vote;
import exceedvote.model.VoteList;
import exceedvote.model.dao.mongo.MongoContestantDAO;
import exceedvote.model.dao.mongo.MongoCriterionDAO;
import exceedvote.model.dao.mongo.MongoDaoFactory;
import exceedvote.model.dao.mongo.MongoUserDAO;

@Path("api/v1/")
public class ExceedVoteResource {
	
	private static MongoDaoFactory daoInstance = MongoDaoFactory.getInstance();
	private static MongoCriterionDAO criterionDAO = daoInstance.getCriterionDAO();
	private static MongoContestantDAO contestantDAO = daoInstance.getContestantDAO();
	private static MongoUserDAO userDAO = daoInstance.getUserDAO();
	
	@GET
	//@RolesAllowed({"admin"})
	@Produces(MediaType.APPLICATION_XML)
	public Response get(@Context SecurityContext sec) {
		String username = sec.getUserPrincipal().getName();
		int contestant = contestantDAO.findAll().size();
		int criteria = criterionDAO.findAll().size();
		StringBuilder sb = new StringBuilder();
		sb.append("<html><head><title>WORKING</title></head><body>SERVER IS WORKING<br>");
		sb.append("Username : ").append(username).append("<br>");
		sb.append("Contestant Count : ").append(contestant).append("<br>");
		sb.append("Criteria Count : ").append(criteria).append("<br>");
		sb.append("</body></html>");
//		String username = sec.getUserPrincipal().getName();
//		int contestant = MongoDaoFactory.getInstance().getContestantDAO().findAll().size();
//		int criteria = MongoDaoFactory.getInstance().getCriterionDAO().findAll().size();
//		StringBuilder sb = new StringBuilder();
//		sb.append("<html><head><title>WORKING</title></head><body>SERVER IS WORKING<br>");
//		sb.append("Username : ").append(username).append("<br>");
//		sb.append("Contestant Count : ").append(contestant).append("<br>");
//		sb.append("Criteria Count : ").append(criteria).append("<br>");
//		sb.append("</body></html>");
		String sb = "<link rel=\"criterion\" href=\"http://127.0.0.1:8080/exceedvote/api/v1/criterion\"/><link rel=\"contestant\" href=\"http://127.0.0.1:8080/exceedvote/api/v1/contestant\"/><link rel=\"myvote\" href=\"http://127.0.0.1:8080/exceedvote/api/v1/myvote\"/>";
		return Response.ok().entity(sb.toString()).build();
	}
	
	@GET
	@Path("contestant")
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Response getContestants(@Context SecurityContext sec) {
		ContestantList contestant = new ContestantList();
		contestant.setContestantList( contestantDAO.findAll());
		return Response.ok().entity(contestant).build();
	}
	
	@GET
	@Path("contestant/{id}")
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Response getContestant(@Context SecurityContext sec,@PathParam("id") int id) {
		return Response.ok().entity(contestantDAO.findById(id)).build();
	}
	
	@GET
	@Path("criterion")
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Response getCriterias(@Context SecurityContext sec) {
		CriterionList ql = new CriterionList();
		ql.setCriterionList(criterionDAO.findAll());
		return Response.ok().entity(ql).build();
	}
	
	@GET
	@Path("criterion/{id}")
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Response getCriteria(@Context SecurityContext sec,@PathParam("id") int id) {
		return Response.ok().entity(criterionDAO.findById(id)).build();
	}
	
	@POST
	@Path("criterion/{id}/vote")
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Response makeVote(@Context SecurityContext sec,@PathParam("id") int id,Vote vote) {
		Vote vS = new Vote(userDAO.findByUsername(sec.getUserPrincipal().getName()), criterionDAO.findById(id));
		//vote.setUser(userDAO.findByUsername(sec.getUserPrincipal().getName()));
		for(Ballot ballot : vote.getBallots()) {
			Ballot b = new Ballot(ballot.getContestant(), ballot.getScore(), vS.getVoteID());
			daoInstance.getBallotDAO().save(b);
		}
		daoInstance.getVoteDAO().save(vS);
		return Response.status(201).build();
	}
	
	@GET
	@Path("myvote")
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Response myvote(@Context SecurityContext sec){
		VoteList vl = new VoteList();
		List<Vote> v2 = daoInstance.getVoteDAO().findByUserId(userDAO.findByUsername(sec.getUserPrincipal().getName()).getUserID());
		for(int i = 0; i < v2.size(); i++) {
			List<Ballot> ballots = daoInstance.getBallotDAO().findByVoteId(v2.get(i).getVoteID());
			v2.get(i).setBallots(ballots);
		}
		vl.setVoteList(v2);
		try {
			return Response.ok().entity(vl).build();
		} catch (NullPointerException npe) {
			return Response.noContent().build();
		}
	}
	
	@GET
	@Path("rank")
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Response getRank(@Context SecurityContext sec) {
		Rank rank = new Rank();
		return Response.ok().entity(rank).build();
	}
}
