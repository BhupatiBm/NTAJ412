package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PasportServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    PrintWriter pw=null;
    String name=null,gender=null,nationality=null;
    int age=0;
    pw=resp.getWriter();
    resp.setContentType("text/html");
    name=req.getParameter("name");
    age=Integer.parseInt(req.getParameter("age"));
    gender=req.getParameter("gender");
    nationality=req.getParameter("nationality");
    if(nationality.equalsIgnoreCase("ind"))
    {
    	if(age>=10)
    	{
    		pw.println("<h1 style='color:green;text-align=center'>Mr/Miss. "+name+" you are eligible for passport</h1>");
    	}
    	else
    		pw.println("<h1 style='color:red;text-align=center'>Mr/Miss. "+name+" you are NOT eligible for passport....because you are under-age</h1>");
    }
    else
    {
    	pw.println("<h1 style='color:red;text-align=center'>Mr/Miss. "+name+" you are NOT eligible for passport....Because you are not indian</h1>");
	}
    pw.println("<a href='input.html'>home</a>");
    pw.close();
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	doGet(req, resp);
	}

}
