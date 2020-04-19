package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/searchurl")
public class SearchServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		String ss=null,engine=null,url=null;
		pw=res.getWriter();
		res.setContentType("text/html");
		ss=req.getParameter("ss");
		engine=req.getParameter("engine");
		
		if(engine.equalsIgnoreCase("google"))
			url="https://www.google.com/search?q="+ss;
		else if(engine.equalsIgnoreCase("bing"))
			url="https://www.bing.com/search?q="+ss;
		else if(engine.equalsIgnoreCase("yahoo"))
			url="https://in.search.yahoo.com/search?p="+ss;
		else 
			url="https://www.ask.com/web?q="+ss;
		
		System.out.println("Before SearchServlet::sendRedirect");
		pw.println("<b>Before sendRedirect</b>");
		res.sendRedirect(url);
		pw.println("<b>After sendRedirect</b>");
		System.out.println("After SearchServlet::sendRedirect");
		pw.close();
	
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
