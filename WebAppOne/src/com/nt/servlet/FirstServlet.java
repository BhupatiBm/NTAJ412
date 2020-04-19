package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/firsturl")
public class FirstServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		int val=0,square=0;
		pw=res.getWriter();
		res.setContentType("text/html");
		val=Integer.parseInt(req.getParameter("t1"));
		square=val*val;
		pw.println("<h1>First Servlet Square::"+square+"</h1>");
		ServletContext sc1=getServletContext();
		ServletContext sc2=sc1.getContext("/WebAppTow");
		RequestDispatcher rd=sc2.getRequestDispatcher("/secondurl");
		rd.include(req, res);
		pw.close();
	}

	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		doGet(req, res);
	}

}
