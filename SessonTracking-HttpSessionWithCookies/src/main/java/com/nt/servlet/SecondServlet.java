package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/secondurl")
public class SecondServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		PrintWriter pw=null;
		String experience=null,skill=null;
		HttpSession session=null;
		
		//get printwriter streem
		pw=res.getWriter();
		res.setContentType("text/html");
		//read form2 data
		experience=req.getParameter("experience");
		skill=req.getParameter("skill");
		//get access to session object
		session=req.getSession(false);
		//keep form2/request2 data in session attribute
		session.setAttribute("experience",experience);
		session.setAttribute("skill",skill);
		//generate form2 dynamically
		pw.println("<h1 style='color:red;text-align:center;'>PROVIDE DESIRED CITY AND EXPECTED SALLARY</h1><br>");
		pw.println("<form action='thirdurl' method='post'>");
		pw.println("Prefered City::<input type='text' name='city'><br>");
		pw.println("Expected sallary::<input type='text' name='salary'><br>");
		pw.println("<input type='submit'value='submit'>");
		pw.println("</form>");
		//close printwriter streem
		pw.close();
		
		
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
