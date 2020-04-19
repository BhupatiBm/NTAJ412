package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/s1url")
public class Servlet1 extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		String name=null,ms=null;
		String age=null;
		//get printwriter streem
		pw=res.getWriter();
		res.setContentType("text/html");
		name=req.getParameter("pname");
		age=req.getParameter("page");
		ms=req.getParameter("ms");
		if(ms.contentEquals("single")) {
			pw.println("<h1 style='color:red;text-align:center;'>Enter your personal details</h1>");
			pw.println("<form action='s2url' method='post'>");
			pw.println("When to marry::<input type='text'name='wtm1'><br>");
			pw.println("Why to marry::<input type='text'name='wtm2'><br>");
			pw.println("<input type='submit' value='contniue'><br>");
			pw.println("</form>");
		}
		else {
			pw.println("<h1 style='color:red;text-align:center;'>Enter your Marital details</h1>");
			pw.println("<form action='s2url' method='post'>");
			pw.println("Spouce name::<input type='text' name='wtm1'><br>");
			pw.println("No of child::<input type='text' name='wtm2'><br>");
			pw.println("<input type='submit' value='contniue'><br>");
			pw.println("</form>");
		}
		pw.close();
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
