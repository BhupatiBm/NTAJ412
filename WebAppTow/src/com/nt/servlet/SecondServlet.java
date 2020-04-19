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
@WebServlet("/secondurl")
public class SecondServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		int val=0,cube=0;
		pw=res.getWriter();
		res.setContentType("text/html");
		val=Integer.parseInt(req.getParameter("t1"));
		cube=val*val*val;
		pw.println("<h1>First Servlet Cube::"+cube+"</h1>");
		
	}

	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		doGet(req, res);
	}

}
