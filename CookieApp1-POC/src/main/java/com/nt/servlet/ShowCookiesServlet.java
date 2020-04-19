package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/shcsurl")
public class ShowCookiesServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		Cookie cks[]=null;  
		PrintWriter pw=null;
		pw=res.getWriter();
		res.setContentType("text/html");
		cks=req.getCookies();
		for(Cookie ck:cks) {
			pw.println("<tr><td>"+ck.getName()+"</td>"+"<td>"+ck.getValue()+"</td></tr><br>");
		}
		pw.close();
				
		}
	
}
