package com.project.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.project.model.LoginVO;
import com.project.model.RegisterVO;
import com.project.service.LoginService;

@Controller
public class LoginController {

	@Autowired
	private LoginService loginService;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView loadLogin() {
		return new ModelAndView("index");
	}

	@RequestMapping(value = "register", method = RequestMethod.GET)
	public ModelAndView loadRegister() {
		return new ModelAndView("register", "RegisterVO", new RegisterVO());
	}

	@RequestMapping(value = "saveUserDetails", method = RequestMethod.POST)
	public ModelAndView saveUserDetails(@ModelAttribute RegisterVO registerVO) {
		LoginVO loginVO = registerVO.getLoginVO();
		loginVO.setEnabled(1);
		loginVO.setRole("ROLE_USER");
		loginVO.setPassword(bCryptPasswordEncoder.encode(loginVO.getPassword()));
		this.loginService.save(loginVO);
		this.loginService.insertRegister(registerVO);
		return new ModelAndView("redirect:/login");
	}

	@RequestMapping(value = "/user/index", method = RequestMethod.GET)
	public ModelAndView userIndex() {
		return new ModelAndView("user/index");
	}

	@RequestMapping(value = "/admin/index", method = RequestMethod.GET)
	public ModelAndView adminIndex() {
		return new ModelAndView("admin/index");
	}

	@RequestMapping(value = "/logout", method = { RequestMethod.POST, RequestMethod.GET })
	public String viewUserDetails(ModelMap model, HttpServletResponse response, HttpServletRequest request) {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
			request.getSession().invalidate();
			request.getSession().setAttribute("tempStatus", "success");
			request.getSession().setAttribute("statusText", "Logout Successfully!");
		}
		return "login";
	}

	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public ModelAndView load403() {
		return new ModelAndView("login");
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login() {
		return new ModelAndView("login");
	}

}