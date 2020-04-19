package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SubmitServlet extends HttpServlet {
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		String s=null;
		float val1=0.0f,val2=0.0f;
		pw=res.getWriter();
		res.setContentType("text/html");
		s=req.getParameter("s1");
		if(!s.equalsIgnoreCase("link1")&(!s.equalsIgnoreCase("link2"))){
			val1=Float.parseFloat(req.getParameter("val1"));
			val2=Float.parseFloat(req.getParameter("val2"));
			if(s.equalsIgnoreCase("add")) {
				pw.println("<h1 style='color:green;text-align:center'>Final add value is::"+(val1+val2)+"</h1>");
			}
			else if(s.equalsIgnoreCase("sub")) {
				pw.println("<h1 style='color:green;text-align:center'>Final sub value is::"+(val1-val2)+"</h1>");
			}
			else if(s.equalsIgnoreCase("mul")) {
				pw.println("<h1 style='color:green;text-align:center'>Final mul value is::"+(val1*val2)+"</h1>");
			}
			else if(s.equalsIgnoreCase("div")) {
				pw.println("<h1 style='color:green;text-align:center'>Final div value is::"+(val1/val2)+"</h1>");
			}
		}
		else if(s.equalsIgnoreCase("link1")) {
			pw.println("<h1 style='color:green;text-align:center'>System info is::</h1>"+System.getProperties());	
		}
		else if(s.equalsIgnoreCase("link2")) {
			pw.println("<h1 style='color:green;text-align:center'>System info is::"+new Date()+"</h1>");	
		}
		pw.println("<a href='form.html'>HOME</a>");
		pw.close();
	}
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	doPost(req,res);
	}

}
