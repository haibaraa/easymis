package org.m.dao;

import org.m.domain.LoginLog;
import org.springframework.stereotype.Repository;

@Repository
public class LoginLogDAO extends BaseDAO {
	
	private static final String INSERT_LOGIN_LOG = "insert into login_log(user_id, ip, login_date) values (?, ?, ?)";
	
	public int insertLoginLog(LoginLog loginLog) {
		Object[] args = new Object[] { loginLog.getUserId(), loginLog.getIp(), loginLog.getLoginDate() };
		int result = this.getJdbcTemplate().update(INSERT_LOGIN_LOG, args);
		return result;
	}
}
