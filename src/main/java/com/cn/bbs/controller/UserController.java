package com.cn.bbs.controller;

import java.net.HttpCookie;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.cn.bbs.model.BbsUser;
import com.cn.bbs.service.LoginService;
import com.cn.bbs.service.TopicService;
@Controller
@RequestMapping(value = "/user")
public class UserController {
	@Autowired
	private LoginService loginService;
	
	
	/**
	 * 登录
	 */
	@RequestMapping(value = "/login")
	public String login(@RequestParam("userName") String userName, @RequestParam("password") String password,
			HttpServletRequest request, HttpServletResponse response) {
		BbsUser bbsUser = loginService.selectByUserName(userName);
		boolean flag=false;
		if(bbsUser!=null){
			System.out.println(bbsUser.getPassword());
			System.out.println(password);
			if (bbsUser.getPassword().equals(password)) {
				  Cookie[] cookies = request.getCookies();
				 if (cookies!=null&&cookies.length!=0) {
					 loop:for (Cookie cookie : cookies) {
						 if (cookie.getName()=="User") {
							 flag=true;
							 cookie.setValue(userName+","+password);
							 break loop;
						 }
					 }
				} 
				    if (!flag)
				    {
				          Cookie cookie = new Cookie("User",userName+","+password);
				          cookie.setMaxAge(24*30*60*60);
				          cookie.setPath("/");
				          response.addCookie(cookie);
				    }
				request.getSession().setAttribute("user", bbsUser);
				return "redirect:/";
			}
		}else {
			return "redirect:/";
		}
		return "redirect:/";
	}
	
	
	/**
	 * 退出登录
	 */
	@RequestMapping(value = "/logout")
	public String logout(HttpServletRequest request, HttpServletResponse response) {
				Cookie[] cookies = request.getCookies();
				for (Cookie cookie : cookies) {
					if (cookie.getName().equals("User")) {
						cookie.setPath("/");
						cookie.setMaxAge(0);
						response.addCookie(cookie);
						break;
					}
				}
				request.getSession().setAttribute("user", null);
				return "redirect:/";
	}
	/**
	 * 注册
	 */
	@RequestMapping(value = "/register")
	public String logout(HttpServletRequest request, HttpServletResponse response,@RequestParam("RuserName") String userName, 
							@RequestParam("nickName") String nickName,
									@RequestParam("Rpassword") String password,
										@RequestParam("emall") String emall, @RequestParam("gender") Integer gender) {
		BbsUser user = new BbsUser();
		user.setUserName(userName);
		user.setNickName(nickName);
		user.setPassword(password);
		user.setEmall(emall);
		user.setGender(gender);
		user.setType(2);
		loginService.insert(user);
		return "redirect:/login?userName="+userName+"&password="+password;
	}
	
	
	/**
	 * 注册时用户名重复检查
	 */
	@RequestMapping(value = "/userNameCheck")
	public @ResponseBody String logout(HttpServletRequest request, HttpServletResponse response,@RequestParam("userName") String userName) {
		BbsUser bbsUser = loginService.selectByUserName(userName);
		if (bbsUser!=null) {
			return "false";
		}
		return "true";
	}
}
