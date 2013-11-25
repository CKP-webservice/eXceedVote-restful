package exceedvote.model.dao;

import java.util.List;

import exceedvote.model.Project;

public interface ProjectDAO {
	public Project find(int id);
	public void save(Project project);
	public void delete(Project project);
	public List<Project> findAll();
	public List<Project> query(String q);
}
