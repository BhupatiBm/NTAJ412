package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FormServlet extends HttpServlet {
		@Override
		public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		String name=null,gender=null,dob=null,ms=null,mail=null,
				phno=null,address=null,qf=null,fc=null,fw=null,fm=null,mb=null;
		String[] hb=null;
		String[] crs=null;
		int age=0;
		pw=res.getWriter();
		res.setContentType("text/html");
		name=req.getParameter("pname");
		age=Integer.parseInt(req.getParameter("page"));
		gender=req.getParameter("pgender");
		
		dob=req.getParameter("dob");
		ms=req.getParameter("ms");
		if(ms==null) {
			ms="un-maried";
		}
		mail=req.getParameter("mail");
		phno=req.getParameter("phno");
		address=req.getParameter("taddress");
		qf=req.getParameter("qf");
		fc=req.getParameter("fc");
		fw=req.getParameter("fw");
		fm=req.getParameter("fm");
		mb=req.getParameter("mb");
		crs=req.getParameterValues("crs");
		hb=req.getParameterValues("hb");
		if(gender.equalsIgnoreCase("m")) {
			if(age<=5)
				pw.println("<h2 style='color:green;text-align:center;'>Master."+name+"You are a Baby Boy</h2>");
			else if(age<=12)
				pw.println("<h2 style='color:green;text-align:center;'>Master."+name+"You are a small Boy</h2>");
			else if(age<=19)
				pw.println("<h2 style='color:green;text-align:center;'>Mr."+name+"You are a teenage Boy</h2>");
			else if(age<=35)
				pw.println("<h2 style='color:green;text-align:center;'>Mr."+name+"You are a young man</h2>");
			else if(age<=50)
				pw.println("<h2 style='color:green;text-align:center;'>Mr."+name+"You are a middle age man</h2>");
			else
				pw.println("<h2 style='color:green;text-align:center;'>Mr."+name+"You are a buddha</h2>");
		}
		else if(gender.equalsIgnoreCase("f")) {
			if(age<=5)
				pw.println("<h2 style='color:pink;text-align:center;'>Miss."+name+"You are a Baby girl</h2>");
			else if(age<=12)
				pw.println("<h2 style='color:pink;text-align:center;'>Miss."+name+"You are a small girl</h2>");
			else if(age<=19)
				pw.println("<h2 style='color:pink;text-align:center;'>Miss."+name+"You are a teenage girl/h2>");
			else if(age<=35) {
				if(ms.equalsIgnoreCase("married")) {
					pw.println("<h2 style='color:pink;text-align:center;'>Mrs."+name+"You are a young leady</h2>");
				}
				else
				pw.println("<h2 style='color:pink;text-align:center;'>Miss."+name+"You are a young leady</h2>");
		     }	
			else if(age<=50) {
				if(ms.equalsIgnoreCase("married")) {
					pw.println("<h2 style='color:pink;text-align:center;'>Mrs."+name+"You are a middle aged leady</h2>");
				}
				else
				pw.println("<h2 style='color:pink;text-align:center;'>Miss."+name+"You are a middle aged leady</h2>");
			}
			else {
				if(ms.equalsIgnoreCase("married")) {
					pw.println("<h2 style='color:pink;text-align:center;'>Mrs."+name+"You are a old leady</h2>");
				}
				else
				pw.println("<h2 style='color:pink;text-align:center;'>Miss."+name+"You are a buddhi leady</h2>");
			}
			pw.println("<h3>Person details:</h3>");
			pw.println("<br>name::"+name);
			pw.println("<br>age::"+age);
			pw.println("<br>gender::"+gender);
			pw.println("<br>Date Of Birth::"+dob);
			pw.println("<br>marrital status::"+ms);
			pw.println("<br>mail::"+mail);
			pw.println("<br>phno::"+phno);
			pw.println("<br>address::"+address);
			pw.println("<br>qualification::"+qf);
			pw.println("<br>course::"+Arrays.toString(crs));
			pw.println("<br>hobbies::"+Arrays.toString(hb));
			pw.println("<br>fav.color::"+fc);
			pw.println("<br>fav.week::"+fw);
			pw.println("<br>fav.month::"+fm);
			pw.println("<br>monthly budget::"+mb);
			pw.println("<a href='form.html'>home</a>");
			pw.close();
			
		}
		
		
		
		}
}
