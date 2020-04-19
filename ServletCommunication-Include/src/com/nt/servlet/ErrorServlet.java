package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/errurl")
public class ErrorServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		RequestDispatcher rd1=null,rd2=null;
		rd1=req.getRequestDispatcher("/headurl");
		rd1.include(req, res);
		PrintWriter pw=null;
		pw=res.getWriter();
		res.setContentType("text/html");
		pw.println("<b>ErrorServlet.java");
		pw.println("<h1 style='color:red;text-align:center;'>INTERNAL ERROR</h1>");
		rd2=req.getRequestDispatcher("/footer.html");
		rd2.include(req, res);
	}
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		doGet(req, res);
	}

}
