/**
 * 
 */
/**
 * @author Administrator
 *
 */
package com.demo.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


@WebFilter(filterName="customFilter",urlPatterns={"/*"})
public class CustomFilter implements Filter{
	private Log log=LogFactory.getLog(CustomFilter.class);
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		log.info("destroy customFilter");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		log.info("dofilter 请求处理");
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		log.info("init customFilter");
	}
	
}