package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LcTestServlet extends HttpServlet {
	static {
		System.out.println("LcTestServlet.enclosing_method()::static block");
	}
	public LcTestServlet() {
		System.out.println("LcTestServlet.LcTestServlet()::0-param constructor");
	}
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("LcTestServlet.init()::init(ServletConfig)");
		
	}

	public void service (HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		System.out.println("LcTestServlet.service()::service(_,_)");
		PrintWriter pw= null;
		pw=res.getWriter();
		res.setContentType("text/html");
		pw.println(new java.util.Date());
		res.setHeader("refresh","10");
		pw.close();
	}
	
	public void destroy() {
	System.out.println("LcTestServlet.destroy()::Destroy()");
	}

}
