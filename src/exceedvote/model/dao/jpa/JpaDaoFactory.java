package exceedvote.model.dao.jpa;

import exceedvote.model.dao.DaoFactory;
import exceedvote.model.dao.Login_logDAO;
import exceedvote.model.dao.ProjectDAO;
import exceedvote.model.dao.QuestionDAO;
import exceedvote.model.dao.RoleDAO;
import exceedvote.model.dao.TimeDAO;
import exceedvote.model.dao.UserDAO;
import exceedvote.model.dao.VoteDAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaDaoFactory extends DaoFactory{

	private EntityManager em;
	private EntityManagerFactory emf;
	private JpaProjectDAO projectDAO;
	private JpaQuestionDAO questionDAO;
	private JpaUserDAO userDAO;
	private JpaVoteDAO voteDAO;
	private Login_logDAO login_logDAO;
	private TimeDAO timeDAO;
	private RoleDAO roleDAO;
	
	public JpaDaoFactory()
	{
		emf = Persistence.createEntityManagerFactory("eXceedVote");
		System.out.println(emf.toString());
		em = emf.createEntityManager();
	}
	

	@Override
	public ProjectDAO getProjectDAO() {
		if(projectDAO == null) projectDAO = new JpaProjectDAO(em);
		return projectDAO;
	}

	@Override
	public QuestionDAO getQuestionDAO() {
		if(questionDAO == null) questionDAO = new JpaQuestionDAO(em);
		return questionDAO;
	}

	@Override
	public UserDAO getUserDAO() {
		if(userDAO == null) userDAO = new JpaUserDAO(em);
		return userDAO;
	}

	@Override
	public VoteDAO getVoteDAO() {
		if(voteDAO == null) voteDAO = new JpaVoteDAO(em);
		return voteDAO;
	}


	@Override
	public Login_logDAO getLogin_logDAO() {
		if(login_logDAO == null) login_logDAO = new JpaLogin_logDAO(em);
		return login_logDAO;
	}
	
	@Override
	public TimeDAO getTimeDAO() {
		if(timeDAO == null) timeDAO = new JpaTimeDAO(em);
		return timeDAO;
	}
	
	@Override
	public RoleDAO getRoleDAO() {
		if(roleDAO == null) roleDAO = new JpaRoleDAO(em);
		return roleDAO;
	}

}
