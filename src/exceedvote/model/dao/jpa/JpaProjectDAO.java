package exceedvote.model.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import exceedvote.model.Project;
import exceedvote.model.dao.ProjectDAO;

public class JpaProjectDAO implements ProjectDAO {

	private EntityManager em;
	
	public JpaProjectDAO(EntityManager em) {
		this.em = em;
	}
	@Override
	public Project find(int id) {
		return em.find(Project.class , id);
	}

	@Override
	public void save(Project project) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(project);
		tx.commit();

	}

	@Override
	public void delete(Project project) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(project);
		tx.commit();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Project> findAll() {
		String query = "SELECT p FROM Project p";
		return em.createQuery(query).getResultList();
	}

	@Override
	public List<Project> query(String q) {
		// TODO Auto-generated method stub
		return null;
	}

}
