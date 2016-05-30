package org.m.dao;

import org.m.domain.User;

public interface UserMapper {

	public int getMatchCount(String email, String password);

	public User findUserByEmail(String email);
	
	public User getUser(Long id);

	public int updateLoginInfo(User user);
}
