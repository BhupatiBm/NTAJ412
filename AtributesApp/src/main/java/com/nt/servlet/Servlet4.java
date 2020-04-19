package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.jws.WebService;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/s4url")
public class Servlet4 extends HttpServlet {
		public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			RequestDispatcher rd=null;
			HttpSession ses=null;
			ServletContext sc=null;
			PrintWriter pw=null;
			//get printwriter streem
			pw=res.getWriter();
			//set content type
			res.setContentType("text/html");
			//read and display reqest atribute value
			pw.println("<b>Servlet4 attr1 atribute value::"+req.getAttribute("attr1")+"<br>");
			//read and display session atribute value
			ses=req.getSession();
			pw.println("<b>Servlet4 attr2 atribute value::"+ses.getAttribute("attr2")+"<br>");
			/*	//read and display servlst context atribute value
			sc=getServletContext();
			pw.println("<b>Servlet4 attr3 atribute value::"+sc.getAttribute("attr2")+"<br>");
			*/
			pw.close();
		}
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
