package exceedvote.resource;

import java.io.IOException;

import javax.annotation.security.RolesAllowed;
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

import com.sun.security.auth.UserPrincipal;

import exceedvote.model.ContestantList;
import exceedvote.model.CriterionList;
import exceedvote.model.Vote;
import exceedvote.model.dao.mongo.MongoDaoFactory;

@Path("/")
public class ExceedVoteResource {
	
	
	
	@GET
	@RolesAllowed({"admin"})
	@Produces(MediaType.TEXT_HTML)
	public Response get(@Context SecurityContext sec) {
		return Response.ok().entity("<html><head><title>WORKING</title></head><body>SERVER IS WORKING</body></html>").build();
		
	}
	
	@GET
	@Path("contestant")
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Response getContestants(@Context SecurityContext sec) {
		ContestantList contestant = new ContestantList();
		try {
			contestant.setContestantList( MongoDaoFactory.getInstance().getContestantDAO().findAll());
			return Response.ok().entity(contestant).build();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return Response.status(500).build();
		
	}
	
	@GET
	@Path("contestant/{id}")
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Response getContestant(@Context SecurityContext sec,@PathParam("id") int id) {
		try {
			return Response.ok().entity(MongoDaoFactory.getInstance().getContestantDAO().findById(id)).build();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return Response.status(500).build();
	}
	
	@GET
	@Path("criteria")
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Response getCriterias(@Context SecurityContext sec) {
		CriterionList ql = new CriterionList();
		try {
			ql.setCriterionList(MongoDaoFactory.getInstance().getCriterionDAO().findAll());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return Response.ok().entity(ql).build();
	}
	
	@GET
	@Path("criteria/{id}")
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Response getCriteria(@Context SecurityContext sec,@PathParam("id") int id) {
		try {
			return Response.ok().entity(MongoDaoFactory.getInstance().getCriterionDAO().findById(id)).build();
		} catch (IOException e) {
			
		}
		return Response.status(500).build();
	}
	
	@POST
	@Path("criteria/{id}/vote")
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Response makeVote(@Context SecurityContext sec,@PathParam("id") int id,Vote vote) {
		try {
			MongoDaoFactory.getInstance().getVoteDAO().save(vote);
			return Response.ok().build();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Response.status(500).build();
	}
	
	@GET
	@Path("myvote")
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Response myvote(@Context SecurityContext sec){
		try {
			return Response.ok().entity(MongoDaoFactory.getInstance().getVoteDAO().findAll()).build();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Response.status(500).build();
	}
	
	@GET
	@Path("rank")
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Response getRank(@Context SecurityContext sec) {
		try {
			return Response.ok().entity(MongoDaoFactory.getInstance()).build();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Response.status(500).build();
	}
}
