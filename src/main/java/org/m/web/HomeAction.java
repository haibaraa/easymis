package org.m.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeAction {

	@RequestMapping("/home.html")
	public String home(Model model){
		model.addAttribute("msg", "Hello world!");
		return "home";
	}
}
