//XMLurl
package com.nt.servlet;
import javax.servlet.*;
import javax.servlet.http.*;

import java.io.*;
public class XmlServlet extends HttpServlet
{
	static {
		System.out.println("XmlServlet.service()::static block");
	}
	private XmlServlet() {
		System.out.println("XmlServlet.XmlServlet()::0 param constructor");
	}
	
	public void init() throws ServletException {
	System.out.println("XmlServlet.init()::init(ServletConfig)");
	}
	public void service (HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		System.out.println("XmlServlet.service()::service(_,_)");
		PrintWriter pw= null;
		pw=res.getWriter();
		res.setContentType("text/xml");
		pw.println("<table border='1'>");
		pw.println("<tr><th>player name</th><th>role</th><th>nick name</th></tr>");
		pw.println("<tr><td>dhoni</td><td>weeket keeper</td><td>mr perfect</td></tr>");
        pw.println("<tr><td>virat</td><td>cptain</td><td>run machine</td></tr>");
		pw.println("<tr><td>rohit</td><td>vice.captain</td><td>hit man</td></tr>");
		pw.close();
	}
	@Override
	public void destroy() {
	System.out.println("XmlServlet.destroy()::destroy()");
	}
}