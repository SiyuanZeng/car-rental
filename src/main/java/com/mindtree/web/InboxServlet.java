package com.mindtree.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class InboxServlet
 */
public class InboxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter(); 
		out.print("Session Information <br/>");
		HttpSession session = request.getSession(false);
		if( session == null || session.getAttribute("user") == null) {
			// user has not login, redirect him to Login page
			response.setHeader("Refresh", "2;url=Login.jsp");
			out.print("Please Login. You will be redirected to Login page in 2 seconds...");
		} else {
			String uname = (String) session.getAttribute("user");
			out.print("User Name : " + uname);
		}
		out.print("<a href=\"Login\">Sign Out</a>");
	}

}
