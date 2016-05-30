package org.m.dao;

import org.m.domain.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAO extends BaseDAO{
	
	private static final String GET_MATCH_COUNT= "select count(1) from user where email = ? and password = ?";
	private static final String FIND_USER_BY_EMAIL= "select id,email,name,last_visit,last_ip from user where email = ?";
	private static final String GET_USER= "select id,email,name,last_visit,last_ip from user where id = ?";
	private static final String UPDATE_LOGIN_INFO= "update user set last_visit = ? , last_ip = ? where id = ?";

	public int getMatchCount(String email, String password) {
		Object[] args = new Object[] { email, password };
		int exist = this.getJdbcTemplate().queryForObject(GET_MATCH_COUNT, args, Integer.class);
		return exist;
	}

	public User findUserByEmail(String email) {
		Object[] args = new Object[] { email };
		User user = this.getJdbcTemplate().queryForObject(FIND_USER_BY_EMAIL, args, new BeanPropertyRowMapper<User>(User.class));
		return user;
	}

	public User getUser(Long id) {
		Object[] args = new Object[] { id };
		User user = this.getJdbcTemplate().queryForObject(GET_USER, args, new BeanPropertyRowMapper<User>(User.class));
		return user;
	}

	public int updateLoginInfo(User user) {
		Object[] args = new Object[] { user.getLastVisit(), user.getLastIp(), user.getId() };
		int result = this.getJdbcTemplate().update(UPDATE_LOGIN_INFO, args);
		return result;
	}
}
