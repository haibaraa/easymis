package org.m.web;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.m.domain.User;
import org.m.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginAction {

	@Autowired
	private UserService userService;
	
	@RequestMapping("login.html")
	public String login() {
		return "login";
	}
	
	@RequestMapping(value = "login.html", method = RequestMethod.POST)
	public ModelAndView login(HttpServletRequest request, User user) {
		User loginUser = null;
		boolean isValidUser = userService.hasMatchUser(user.getEmail(), user.getPassword());
		if (!isValidUser) {
			return new ModelAndView("login" ,"error", "用户名或密码错误。");
		} else {
			loginUser = userService.findUserByEmail(user.getEmail());
			loginUser.setLastIp(request.getLocalAddr());
			loginUser.setLastVisit(new Date());
			userService.loginSuccess(loginUser);
			request.getSession().setAttribute("user", loginUser);
		}
		return new ModelAndView("main", "user", loginUser);
	}
}
