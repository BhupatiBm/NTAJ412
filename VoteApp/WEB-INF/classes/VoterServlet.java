//VoterServlet.java
package com.nt.servlet;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
public class VoterServlet extends HttpServlet
{
	public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		PrintWriter pw=null;
		String name=null,tage=null;
		int age=0;
		System.out.println("doGet");
		pw=res.getWriter();
		res.setContentType("text/html");
		name=req.getParameter("name");
		tage=req.getParameter("age");
		age=Integer.parseInt(tage);
		if(age>=18)
		{
			pw.println("<h1 style='color:green;text-align:center'>mr/miss "+name+"is eligible for vote</h1>");
		}
		else
		{
			pw.println("<h1 style='color:green;text-align:center'>mr/miss "+name+"is not eligible for vote</h1>");
		}
		pw.println("<a href='input.html'><img src='home.png'></a>");
			pw.close();
		

	}
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		System.out.println("doPost");
		PrintWriter pw=null;
		String name=null,tage=null;
		int age=0;
		
		pw=res.getWriter();
		res.setContentType("text/html");
		name=req.getParameter("name");
		tage=req.getParameter("age");
		age=Integer.parseInt(tage);
		if(age>=18)
		{
			pw.println("<h1 style='color:green;text-align:center'>mr/miss "+name+"is eligible for vote</h1>");
		}
		else
		{
			pw.println("<h1 style='color:green;text-align:center'>mr/miss "+name+"is not eligible for vote</h1>");
		}
		pw.println("<a href='input.html'><img src='home.png'></a>");
			pw.close();
		
		
	}

}