package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/firsturl")
public class FirstServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		PrintWriter pw=null;
		String name=null,address=null,age=null;
		HttpSession session=null;
		
		//get printwriter streem
		pw=res.getWriter();
		res.setContentType("text/html");
		//read form1 data
		name=req.getParameter("name");
		address=req.getParameter("address");
		age=req.getParameter("age");
		//create session for form1 data
		session=req.getSession(true);
		//keep form1/request1 data in session attribute
		session.setAttribute("name",name);
		session.setAttribute("address",address);
		session.setAttribute("age", age);
		//generate form2 dynamically
		pw.println("<h1 style='color:red;text-align:center;'>PROVIDE YOUR SKILL AND EXPERIENCE</h1><br>");
		pw.println("<form action='secondurl' method='post'>");
		pw.println("Year of experience::<input type='text' name='experience'><br>");
		pw.println("Skill::<select name='skill'>");
		pw.println("<option value='IT'>IT Services</option>");
		pw.println("<option value='Banking'>Banking</option>");
		pw.println("<option value='HealthCare'>HealthCare</option>");
		pw.println("<option value='Management'>Management</option>");
		pw.println("</select>");
		pw.println("<input type='submit'value='contniue'>");
		pw.println("</form>");
		//close printwriter streem
		pw.close();
		
		
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
