package com.mindtree.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/*
	 * Store Userinformation
	 * key is username, value is  password of user
	 */
	Map<String, String> userMap = new HashMap<String, String>();

	/*
	 * Do all one time initization in init().
	 * We are using this data instead of real database.
	 * (non-Javadoc)
	 * @see javax.servlet.GenericServlet#init()
	 */
	public void init() {
		/*
		 * These are valid username/password
		 */
		userMap.put("Gavin", "King123");
		userMap.put("James", "s3cr3t");
		userMap.put("Gosling", "Mustang");
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 // this code is called when user clicks sign-out
		HttpSession ses = request.getSession(false);
		ses.invalidate();
		response.sendRedirect("Login.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String target = "Login.jsp?message=Invalid User / Password";
		 boolean isUserValid = false;
		 String userName = request.getParameter("userName");
		 String password = request.getParameter("password");
		 /*
		  * if username is valid
		  */
		 if( userMap.containsKey(userName)) {
			 // get actual password
			 String actualPassword = userMap.get(userName);
			 // if actualPasssword matches with entered password
			 if( password.equals(actualPassword)){
				 isUserValid = true;
			 }
		 }

		 if(isUserValid) {
			 HttpSession session = request.getSession(true);
			 session.setAttribute("user", userName);
			 target = "Home.jsp";
		 }
		 response.sendRedirect(response.encodeRedirectURL(target));
	}

}
