package exceedvote.model.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import exceedvote.model.Login_log;
import exceedvote.model.dao.Login_logDAO;

public class JpaLogin_logDAO implements Login_logDAO {

	private EntityManager em;
	
	public JpaLogin_logDAO(EntityManager em) {
		this.em = em;
	}
	@Override
	public Login_log find(int id) {
		return em.find(Login_log.class , id);
	}

	@Override
	public void save(Login_log log) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(log);
		tx.commit();

	}

	@Override
	public void delete(Login_log log) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(log);
		tx.commit();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Login_log> findAll() {
		String query = "SELECT log FROM Login_log log";
		return em.createQuery(query).getResultList();
	}

	@Override
	public List<Login_log> query(String q) {
		// TODO Auto-generated method stub
		return null;
	}

}
