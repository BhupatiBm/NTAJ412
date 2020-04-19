package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/firsturl")
public class FirstServlet extends HttpServlet {
		
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
		String pname=null,fname=null,ms=null,age=null;
		Cookie ck1=null,ck2=null,ck3=null,ck4=null;
		PrintWriter pw=null;
		pw=res.getWriter();
		res.setContentType("text/html");
		
		pname=req.getParameter("pname");
		fname=req.getParameter("fname");
		age=req.getParameter("age");
		ms=req.getParameter("ms");
		
		//create cookie
		
		ck1=new Cookie("pname",pname);
		ck2=new Cookie("fname",fname);
		ck3=new Cookie("age",age);
		ck4=new Cookie("ms",ms);
		
		res.addCookie(ck1);
		res.addCookie(ck2);
		res.addCookie(ck3);
		res.addCookie(ck4);
		
		//pw.println("<b>"+pname+""+fname+""+age+""+ms+"<br>");
		pw.println("<h1 style='color: red;text-align: center;'>ENTER YOUR INCOME DETAILS</h1>");
		pw.println("<form action='secondurl' method='post'> ");
		pw.println("incom per year::<input type='text' name='income'><br>");
		pw.println("tax::<input type='text' name='tax'><br>");
		pw.println("<input type='submit' value='continue'><br>");
		pw.println("</form>");
		//pw.println("<b>"+pname+""+fname+""+age+""+ms+"<br>");
		pw.close();
	}

	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
		doGet(req, res);
	}

}
