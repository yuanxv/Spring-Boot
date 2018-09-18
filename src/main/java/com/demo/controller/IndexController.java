package com.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
	@RequestMapping("/index")
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("login.html");
		return mv;
	}

	@RequestMapping("/login2")
	public @ResponseBody String login(HttpServletRequest request) {
		request.getSession().setAttribute("user", "yuanxv");
		return "login success";
	}
}
