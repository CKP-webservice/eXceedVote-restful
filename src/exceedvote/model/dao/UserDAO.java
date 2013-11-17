package exceedvote.model.dao;

import java.util.List;

import exceedvote.model.User;

public interface UserDAO {
	public User find(int id);
	public void save(User user);
	public void delete(User user);
	public List<User> findAll();
	public List<User> query(String q);
}
