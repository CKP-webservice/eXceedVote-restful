package exceedvote.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ProjectList {
	@XmlElement
	List<Project> projects;
	
	public ProjectList() {
		projects = new ArrayList<Project>();
	}
	
	public List<Project> getProjects() {
		return projects;
	}
	
	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}
	
	public boolean addProject(Project project) {
		if(projects.contains(project)) return false;
		return this.projects.add(project);		
	}
}
