package com.wuzl.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.wuzl.model.User;
import com.wuzl.service.UserFunction;

@Controller
public class loginHandler {
	@Autowired
	UserFunction fun;

	@RequestMapping("/login.do")
	public String login(String account, String password, HttpServletRequest request) {
		try {
			User u = fun.login(account, password);
			HttpSession session = request.getSession();
			session.setAttribute("currentUser", u);
		} catch (Exception e) {
			request.setAttribute("message", e.getMessage());
			return "forward:/login.jsp";
		}

		return "redirect:/index.do";
	}

	@RequestMapping("/index.do")
	public String index() {

		return "index";
	}

}
