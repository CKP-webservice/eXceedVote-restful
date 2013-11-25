package exceedvote.model.dao;

import exceedvote.model.dao.TimeDAO;

import exceedvote.model.dao.jpa.JpaDaoFactory;


public abstract class DaoFactory {
	private static DaoFactory daoFactory;
	public static DaoFactory getInstance()
	{
		if(daoFactory == null) daoFactory = new JpaDaoFactory();
		return daoFactory;
	}
	public abstract ProjectDAO getProjectDAO();
	public abstract QuestionDAO getQuestionDAO();
	public abstract UserDAO getUserDAO();
	public abstract VoteDAO getVoteDAO();
	public abstract Login_logDAO getLogin_logDAO();
	public abstract TimeDAO getTimeDAO();
	public abstract RoleDAO getRoleDAO();
}
