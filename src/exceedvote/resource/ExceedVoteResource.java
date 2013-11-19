package exceedvote.resource;

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

import exceedvote.model.ProjectList;
import exceedvote.model.QuestionList;
import exceedvote.model.dao.DaoFactory;

@Path("/")
public class ExceedVoteResource {
	
	@GET
	@Path("contestant")
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Response getContestants(@Context SecurityContext sec) {
		ProjectList pl = new ProjectList();
		pl.setProjects(DaoFactory.getInstance().getProjectDAO().findAll());
		return Response.ok().entity(pl).build();
	}
	
	@GET
	@Path("contestant/{id}")
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Response getContestant(@Context SecurityContext sec,@PathParam("id") int id) {
		return Response.ok().entity(DaoFactory.getInstance().getProjectDAO().find(id)).build();
	}
	
	@GET
	@Path("criteria")
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Response getCriterias(@Context SecurityContext sec) {
		QuestionList ql = new QuestionList();
		ql.setQuestions(DaoFactory.getInstance().getQuestionDAO().findAll());
		return Response.ok().entity(ql).build();
	}
	
	@GET
	@Path("criteria/{id}")
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Response getCriteria(@Context SecurityContext sec,@PathParam("id") int id) {
		return Response.ok().entity(DaoFactory.getInstance().getQuestionDAO().find(id)).build();
	}
	
	@POST
	@Path("criteria/{id}/vote")
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Response makeVote(@Context SecurityContext sec,@PathParam("id") int id) {
		//TODO ~~
		return Response.ok().entity(DaoFactory.getInstance().getQuestionDAO().find(id)).build();
	}
	
	@GET
	@Path("myvote")
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Response myvote(@Context SecurityContext sec){
		return Response.ok().entity(DaoFactory.getInstance().getVoteDAO().findAll()).build();
	}
	
	@GET
	@Path("rank")
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Response getRank(@Context SecurityContext sec) {
		return Response.ok().entity(DaoFactory.getInstance()).build();
		
	}
}
