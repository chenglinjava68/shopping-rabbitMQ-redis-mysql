package org.lee.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.workin.web.spring.ControllerSupport;

import org.lee.request.LoginRequest;
import org.lee.service.IUserService;
import org.lee.util.EncodeUtil;
import org.lee.vo.User;

@Controller
public class LoginController extends ControllerSupport {
	@Autowired
	private IUserService userService;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(LoginRequest login) {
		String password = EncodeUtil.generateMd5(login.getPassword());
		User user = userService.checkUserInfo(login.getLoginName(), password);
		getHttpSession().setAttribute("user", user);
		return user!=null?"main":"index";
	}
	
/*	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(LoginRequest login, HttpServletRequest request, HttpServletResponse response) {
		String password = EncodeUtil.generateMd5(login.getPassword());
		User user = userService.checkUserInfo(login.getLoginName(), password);
		request.getSession().setAttribute("user", user);
		return user!=null?"main":"index";
	}
	*/

	@RequestMapping(value="/logout")
    public String logout(HttpServletRequest request,HttpServletResponse response){
		request.getSession().removeAttribute("user");
    	return "index";
    }
	@RequestMapping("loginPage.do")
	public String loginPage(){
		return "index";
	}
	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

}
