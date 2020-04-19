package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/s2url")
public class Servlet2 extends HttpServlet {
		public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			String name=null,ms=null,f2val1=null,f2val2=null;
			String age=null;
			PrintWriter pw=null;
			pw=res.getWriter();
			res.setContentType("text/html");
			//read form1 data
			name=req.getParameter("pname");
			age=req.getParameter("page");
			ms=req.getParameter("ms");
			pw.println("<b>First form details");
			pw.println("<br>name::"+name);
			pw.println("<br>age::"+age);
			pw.println("<br>Marital status::"+ms);
			//read 2nd form data
			pw.println("Form2 data<br>");
			f2val1=req.getParameter("wtm1");
			f2val2=req.getParameter("wtm2");
			pw.println(""+f2val1+"<br>");
			pw.println(""+f2val2+"<br>");
		
		}
		public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
		doGet(req, res);
	}

}
