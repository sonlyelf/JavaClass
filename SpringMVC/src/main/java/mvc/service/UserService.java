package mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import mvc.dao.UserDao;
import mvc.model.po.User;

public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	public List<User> findUsers(){
		return userDao.findAllUsers();
	}
	
	public User getUser(Integer userId) {
		return userDao.getUserById(userId);
	}
	
	public boolean addUser(User user) {
		return userDao.addUser(user)>0;
	}
	
	public boolean updateUser(Integer userId, User user) {
		return userDao.updateUser(userId, user)>0;
	}
	
	public boolean deleteUser(Integer userId) {
		return userDao.deleteUser(userId)>0;
	}
	
	
}