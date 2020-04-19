package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/scsurl")
public class SetCookiesServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		Cookie ck1,ck2,ck3,ck4;
		PrintWriter pw=null;
		//get printwriter
		pw=res.getWriter();
		//set content type
		res.setContentType("text/html");
		//set value for in-memory cookie
		ck1=new Cookie("Odisha", "Bhubaneswar");
		ck2=new Cookie("Maharastra", "Mumbai");
		//persistance  cookie
		ck3=new Cookie("India", "Dehi");
		ck4=new Cookie("USA", "wasington_dc");
		ck3.setMaxAge(120);
		ck4.setMaxAge(120);
		res.addCookie(ck1);
		res.addCookie(ck2);
		res.addCookie(ck3);
		res.addCookie(ck4);
		pw.println("successfully cookies are seted");
		System.out.println("successfull in setting cookie............");
		pw.close();
	}
	
}
