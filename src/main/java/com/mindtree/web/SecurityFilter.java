package com.mindtree.web;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author Banu Prakash
 * 
 * �2011 MindTree Limited
 * 
 * Servlet Filter implementation class SecurityFilter
 */
public class SecurityFilter implements Filter {
	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest,
	 * javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = null;
		HttpServletResponse res = null;
		/*
		 * If the request is of type HTTP
		 */
		if (request instanceof HttpServletRequest) {
			req = (HttpServletRequest) request;
			res = (HttpServletResponse) response;
		}
		String uri = req.getRequestURI();
		/*
		 * If client has made a request to login.jsp, no need to filter. Invokde
		 * login.jsp
		 */
		if (uri.endsWith("Login.jsp")) {
			chain.doFilter(request, response);
		} else {
			/*
			 * Get session, do not create
			 */
			HttpSession session = req.getSession(false);
			/*
			 * If user attribute exists, then user has login.
			 * invoke which ever resource the user has called.
			 * If user has not login, then send the user to login.jsp.
			 */
			if (session != null && session.getAttribute("user") != null) {
				chain.doFilter(request, response);
			} else {
				res.sendRedirect("Login.jsp");
			}
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
	}

}
