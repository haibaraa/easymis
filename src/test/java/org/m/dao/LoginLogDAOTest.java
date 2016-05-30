package org.m.dao;

import java.util.Date;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.m.domain.LoginLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:ApplicationContext.xml" })
public class LoginLogDAOTest {
	
	@Autowired
	private LoginLogDAO loginLogDAO;
	
	@Ignore
	public void insertLoginLog() {
		LoginLog loginLog = new LoginLog();
		loginLog.setUserId(1L);
		loginLog.setIp("10.0.0.0");
		loginLog.setLoginDate(new Date());
		int result = loginLogDAO.insertLoginLog(loginLog);
		Assert.assertEquals(1, result);
	}
}
