package exceedvote.model.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import exceedvote.model.User;
import exceedvote.model.dao.UserDAO;

public class JpaUserDAO implements UserDAO {

	private EntityManager em;
	public JpaUserDAO(EntityManager em) {
		this.em = em;
	}
	@Override
	public User find(int id) {
		return em.find(User.class, id);
	}

	@Override
	public void save(User user) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(user);
		tx.commit();
		
	}

	@Override
	public void delete(User user) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(user);
		tx.commit();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<User> findAll() {
		String query = "SELECT p FROM User p";
		return em.createQuery(query).getResultList();
	}
	
	@Override
	public List<User> query(String q) {
		// TODO Auto-generated method stub
		return null;
	}

}
