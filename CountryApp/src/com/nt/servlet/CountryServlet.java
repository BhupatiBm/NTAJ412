package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CountryServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		int country_code=0;
		String[] country_captials= {"New Delhi","Islamabad","Bejing","WashingtonDC","Mascow"};
		pw=res.getWriter();
		res.setContentType("text/htm");
		country_code=Integer.parseInt( req.getParameter("country"));
		pw.println("<h2 style='color:red;text-aligen:center'> capital city name:"+country_captials[country_code]+"</h2>");
		pw.println("<a href='country.html'>home<a>");	
		pw.close();
	}
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req,res);
	}

}
