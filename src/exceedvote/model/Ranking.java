package exceedvote.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;


public class Ranking {
//
//	private HashMap<Question,List<ProjectResult>> rankingMap;
//	public Ranking() {
//		this.rankingMap = new HashMap<Question, List<ProjectResult>>();
//		load();
//	}
//	private void load()
//	{
//		DaoFactory daoFactory = DaoFactory.getInstance();
//		QuestionDAO questionDAO = daoFactory.getQuestionDAO();
//		VoteDAO voteDAO = daoFactory.getVoteDAO();
//		ProjectDAO projectDAO = daoFactory.getProjectDAO();
//		List<Question> questionList = questionDAO.findAll();
//		List<Project> projectList = projectDAO.findAll();
//		for(Question q : questionList)
//		{
//			List<Vote> voteList = voteDAO.findByQuestion(q);
//			List<ProjectResult> projectResultList = getInitListProjectResult(projectList);
//			for(Vote v : voteList)
//			{
//				for(int i = 0; i < projectResultList.size(); i++)
//				{
//					if(projectResultList.get(i).getProject().getId() == v.getCriterionID())
//					{
//						projectResultList.get(i).increaseScore();
//						break;
//					}
//				}
//			}
//			Collections.sort(projectResultList, new ProjectResultCompare());
//			this.rankingMap.put(q, projectResultList);
//			
//		}
//	}
//	
//	private List<ProjectResult> getInitListProjectResult(List<Project> projectList)
//	{
//		List<ProjectResult> list = new ArrayList<ProjectResult>();
//		for(Project p : projectList)
//		{
//			ProjectResult temp = new ProjectResult(p);
//			list.add(temp);
//		}
//		return list;
//	}
//	
//	public HashMap<Question,List<ProjectResult>> getRankMap()
//	{
//		return this.rankingMap;
//	}
//	
//	public class ProjectResultCompare implements Comparator<ProjectResult>
//	{
//
//		@Override
//		public int compare(ProjectResult o1, ProjectResult o2) {
//			return o2.getScore() - o1.getScore();
//		}
//		
//	}
}
