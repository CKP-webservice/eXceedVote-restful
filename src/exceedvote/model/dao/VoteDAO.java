package exceedvote.model.dao;

import java.util.List;

import exceedvote.model.Question;
import exceedvote.model.Vote;

public interface VoteDAO {
	public Vote find(int id);
	public void save(Vote vote);
	public void delete(Vote vote);
	public List<Vote> findAll();
	public List<Vote> findByQuestion(Question question);
	public List<Vote> query(String q);
	public List<Vote> findByQuestionIdAndUserId(int q_id,int u_id);
}
