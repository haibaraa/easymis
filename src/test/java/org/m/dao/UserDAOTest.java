package org.m.dao;

import java.util.Date;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.m.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:ApplicationContext.xml" })
public class UserDAOTest {

	@Autowired
	private UserDAO userDAO;
	
	@Test
	public void getMatchCount() {
		String email = "test@m.org";
		String password = "123456";
		int i = userDAO.getMatchCount(email, password);
		Assert.assertEquals(1, i);
	}
	
	@Test
	public void findUserByEmail() {
		String email = "test@m.org";
		User user = userDAO.findUserByEmail(email);
		Assert.assertEquals("测试", user.getName());
	}
	
	@Test
	public void getUser() {
		Long id = 1L;
		User user = userDAO.getUser(id);
		Assert.assertEquals("测试", user.getName());
	}
	
	@Ignore
	public void updateLoginInfo() {
		User user = new User();
		user.setId(1L);
		user.setLastIp("10.0.0.0");
		user.setLastVisit(new Date());
		int result = userDAO.updateLoginInfo(user);
		Assert.assertEquals(1, result);
	}
}
