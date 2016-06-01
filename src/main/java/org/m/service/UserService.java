package org.m.service;

import org.m.dao.LoginLogDAO;
import org.m.dao.LoginLogMapper;
import org.m.dao.UserDAO;
import org.m.dao.UserMapper;
import org.m.domain.LoginLog;
import org.m.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	//private UserDAO userDAO;
	private UserMapper userDAO;
	@Autowired
	//private LoginLogDAO loginLogDAO;
	private LoginLogMapper loginLogDAO;

	public boolean hasMatchUser(String email, String password) {
		return userDAO.getMatchCount(email, password) > 0 ? true : false;
	}
	
	public User findUserByEmail(String email){
		return userDAO.findUserByEmail(email);
	}
	
	public void loginSuccess(User user) {
		userDAO.updateLoginInfo(user);
		LoginLog loginLog = new LoginLog();
		loginLog.setUserId(user.getId());
		loginLog.setIp(user.getLastIp());
		loginLog.setLoginDate(user.getLastVisit());
		loginLogDAO.insertLoginLog(loginLog);
	}
}