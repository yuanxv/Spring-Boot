/**
 * 
 */
/**
 * @author Administrator
 *
 */
package com.demo.intercaptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor{
   Log log= LogFactory.getLog(LoginInterceptor.class);
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object obj) throws Exception {
		// TODO Auto-generated method stub
		log.info("preHandle");
	    HttpSession session = request.getSession();
	    if(session.getAttribute("user")!=null){
	    	return true;
	    }else{
//	    	直接返回视图 或者重定向到url再返回视图
	    	response.sendRedirect("/test/login.html");
//	    	response.sendRedirect("/test/index");
	    	return false;
	    }
	}

	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub
		
	}

	
}