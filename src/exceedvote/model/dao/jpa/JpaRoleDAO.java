package exceedvote.model.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import exceedvote.model.Role;
import exceedvote.model.dao.RoleDAO;

public class JpaRoleDAO implements RoleDAO{

	private EntityManager em;
	public JpaRoleDAO(EntityManager em) {
		this.em = em;
	}
	
	@Override
	public Role find(int id) {
		return em.find(Role.class , id);
	}

	@Override
	public void save(Role role) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(role);
		tx.commit();
	}

	@Override
	public void delete(Role role) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(role);
		tx.commit();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Role> findAll() {
		String query = "SELECT r FROM Role r";
		return em.createQuery(query).getResultList();
	}

	@Override
	public List<Role> query(String q) {
		// TODO Auto-generated method stub
		return null;
	}

}
