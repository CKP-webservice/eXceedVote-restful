package exceedvote.model.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import exceedvote.model.Question;
import exceedvote.model.Vote;
import exceedvote.model.dao.VoteDAO;

public class JpaVoteDAO implements VoteDAO {

	private EntityManager em;
	public JpaVoteDAO(EntityManager em) {
		this.em = em;
	}
	@Override
	public Vote find(int id) {
		return em.find(Vote.class, id);
	}

	@Override
	public void save(Vote vote) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(vote);
		tx.commit();
	}

	@Override
	public void delete(Vote vote) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(vote);
		tx.commit();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Vote> findAll() {
		String query = "SELECT v FROM Vote v";
		return em.createQuery(query).getResultList();
	}

	@Override
	public List<Vote> query(String q) {
		// TODO Auto-generated method stub
		return null;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Vote> findByQuestion(Question question) {
		int qid = question.getId();
		String query = "SELECT v from Vote v WHERE v.questionID = :id";
		Query q = em.createQuery(query);
		q.setParameter("id", qid);
		return q.getResultList();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Vote> findByQuestionIdAndUserId(int q_id, int u_id) {
		String query = "SELECT v from Vote v Where v.questionID = :qid and v.userID = :uid";
		Query q = em.createQuery(query);
		q.setParameter("qid", q_id);
		q.setParameter("uid", u_id);
		return q.getResultList();
	}

}
