package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LinksServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	PrintWriter pw=null;
	String plink=null;
	Locale locales[]=null;
	pw=res.getWriter();
	res.setContentType("text/html");
	plink=req.getParameter("p1");
	locales=Locale.getAvailableLocales();
	if(plink.equalsIgnoreCase("link1")) {
		pw.println("<h2>All Country are</h2>");
		for(Locale lc:locales) {
			pw.println("<b>"+lc.getDisplayCountry()+"</b><br>");
		}
	}
	else if(plink.equalsIgnoreCase("link2")) {
		pw.println("<h2>All Languages are....</h2>");
		for(Locale lc:locales) {
			pw.println("<b>"+lc.getDisplayLanguage()+"</b><br>");
		}
	}
	else {
		pw.println(new java.util.Date());
	}
	pw.println("<a href='links.html'><img src='home.jpg'></a>");
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		doPost(req, res);
	}

}
