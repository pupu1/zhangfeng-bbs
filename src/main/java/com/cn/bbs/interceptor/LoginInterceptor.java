package com.cn.bbs.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.cn.bbs.model.BbsUser;
import com.cn.bbs.service.LoginService;
import com.cn.bbs.service.impl.LoginServiceImpl;

public class LoginInterceptor implements HandlerInterceptor {
	@Autowired
	private LoginService loginService;

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		 /* String url=request.getRequestURI();  
		  System.out.println(url);
	      
	        HttpSession session = request.getSession();
			BbsUser user = (BbsUser) session.getAttribute("user");
			if(user == null){
				 Cookie[] cookies = request.getCookies();
				 if (cookies!=null&&cookies.length!=0) {
					 
					 for (Cookie cookie : cookies) {
						 if (cookie.getName().equals("User")) {
							 String value = cookie.getValue();
							 String[] split = value.split(",");
							 BbsUser bbsUser = loginService.selectByUserName(split[0]);
							 if (bbsUser.getPassword().equals(split[1])) {
								 request.getSession().setAttribute("user", bbsUser);
								 return true;
							 }
						 }
					 }
					  if(url.indexOf("login")>=0||url.equals("/bbs-server/")){  
				            return true;  
				        }  
				 }
				response.sendRedirect(request.getContextPath());
				return false;
			}else{
				return true;
			} */
	       return true; 
		
	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub

	}

	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub

	}

}
