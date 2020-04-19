package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SystemDateServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	 PrintWriter pw=null;
	 String link=null;
	 Calendar calendar=null;
	 pw=res.getWriter();
	 res.setContentType("text/html");
	 calendar=Calendar.getInstance();
	 link=req.getParameter("d1");
	 SimpleDateFormat simpledate=new SimpleDateFormat();
	 if(link.equalsIgnoreCase("link1"))
	 {
		 pw.println("<h1 style='color: blue;text-align: center'>"+new java.util.Date()+"</h1>");
	 }
	 else if(link.equalsIgnoreCase("link2"))
	 {
		 pw.printf("<h1 style='color: blue;text-align: center;'>"+calendar.get(Calendar.DAY_OF_MONTH)+"</h1>");
	 }
	 else if(link.equalsIgnoreCase("link3"))
	 {
		 pw.println("<h1 style='color: blue;text-align: center;'>"+calendar.get(Calendar.MONTH)+"</h1>");
	 }
	 else
	 {
		 pw.println("<h1 style='color: blue;text-align: center;'>"+calendar.get(Calendar.YEAR)+"</h1>"); 
	 }
	 pw.close();
	 
	
	}
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
