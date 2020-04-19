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

@WebServlet("/s2url")
public class Servlet2 extends HttpServlet {
		public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			RequestDispatcher rd=null;
			HttpSession ses=null;
			PrintWriter pw=null;
			ServletContext sc=null;
			//get printwriter streem
			pw=res.getWriter();
			//set content type
			res.setContentType("text/html");
			//read and display reqest atribute value
			pw.println("<b>Servlet2 attr1 atribute value::"+req.getAttribute("attr1")+"<br>");
			//read and display session atribute value
			ses=req.getSession();
			pw.println("<b>Servlet2 attr2 atribute value::"+req.getAttribute("attr2")+"<br>");
			/*	//read and display servlst context atribute value
			sc=getServletContext();
			pw.println("<b>Servlet2 attr3 atribute value::"+sc.getAttribute("attr3")+"<br>");
			*/
			//forward the request to servlet2 component
			rd=req.getRequestDispatcher("/s3url");
			rd.forward(req, res);
			pw.close();
		}
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
