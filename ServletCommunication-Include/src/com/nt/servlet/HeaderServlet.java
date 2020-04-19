package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/headurl")
public class HeaderServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		PrintWriter pw=null;
		pw=res.getWriter();
		res.setContentType("text/html");
		pw.println("<marquee><h1>BBM TECHNOLOGIES</marquee></h1>");
		pw.println("<h4>Date::"+new java.util.Date()+"</h4>");
		pw.println("<a href='input.html'>home</a>");
		
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
