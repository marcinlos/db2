package pl.edu.agh.iisg.bd213lg.hellodb.dao;

import java.util.List;

import pl.edu.agh.iisg.bd213lg.hellodb.domain.User;

public interface UserDao {
	
	public void saveUser(User user);

	public List<User> getAllUser(User user);
	
	public User selectUserById(String userId);
	
	public void deleteUser(User user);
	
}
