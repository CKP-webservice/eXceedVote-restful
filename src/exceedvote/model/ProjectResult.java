package exceedvote.model;

public class ProjectResult {
	private Project project;
	private int score;
	
	public ProjectResult(Project project)
	{
		this.project = project;
		this.score = 0;
	}
	
	public Project getProject()
	{
		return this.project;
	}
	
	public void increaseScore()
	{
		this.score++;
	}
	
	public int getScore() {
		return score;
	}
	
}
