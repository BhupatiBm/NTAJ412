//WORDurl
package com.nt.servlet;
import javax.servlet.*;
import javax.servlet.http.*;

import java.io.*;
public class WordServlet extends HttpServlet
{
	static{
		System.out.println("WordServlet.enclosing_method()::ststic block");
	}
	public WordServlet() {
		System.out.println("WordServlet.WordServlet()::0 param constructor");
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("WordServlet.init()::init(ServletConfig)");
	}
	public void service (HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		System.out.println("WordServlet.service()::service()");
		PrintWriter pw= null;
		pw=res.getWriter();
		res.setContentType("application/msword");
		pw.println("<table border='1'>");
		pw.println("<tr><th>player name</th><th>role</th><th>nick name</th></tr>");
		pw.println("<tr><td>dhoni</td><td>weeket keeper</td><td>mr perfect</td></tr>");
        pw.println("<tr><td>virat</td><td>cptain</td><td>run machine</td></tr>");
		pw.println("<tr><td>rohit</td><td>vice.captain</td><td>hit man</td></tr>");
		pw.close();
	}
	@Override
	public void destroy() {
	System.out.println("WordServlet.destroy()::destroy()");
	}
}