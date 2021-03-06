package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DBServlet2 extends HttpServlet {
	Connection con;
	PreparedStatement ps;
	public void init() {
		try {
			ServletContext sc=getServletContext();
			//ServletConfig cg=getServletConfig();
			String s1=sc.getInitParameter("driver");
			String s2=sc.getInitParameter("url");
			String s3=sc.getInitParameter("dbuser");
			String s4=sc.getInitParameter("dbpwd");
			Class.forName(s1);
			con=DriverManager.getConnection(s2,s3,s4);
			ps=con.prepareStatement("SELECT EMPNO,EMPNAME,EMPDEPT,EMPSAL FROM EMPLOYEE_DETAILS WHERE EMPNO=?");
			//ps=con.prepareStatement("SELECT EMPNO,ENAME,JOB,SAL FROM EMPLOYEE_DETAILS WHERE EMPNO=?");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}//init close
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		try {
			PrintWriter pw;
			pw=res.getWriter();
			res.setContentType("text/html");
			int no=Integer.parseInt(req.getParameter("teno"));
			ps.setInt(1,no);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				pw.println("<h4 style='color:green;text-align:center'><br>Employee No: "+rs.getInt(1)+"</h4>");
				pw.println("<br>Employee Name: "+rs.getString(2));
				pw.println("<br>Employee Desg: "+rs.getString(3));
				pw.println("<br>Employee Salary: "+rs.getFloat(4));
			}
			else
				pw.println("<br><h4 style='color:green;text-align:center'>No Employee Found!! Invalid Input</h4>");
			pw.println("<br><br><a href='input.html'>-- HOME --</a>");
			pw.println("<br><br>*******************************************");
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}//doGet(- -)
	
	 @Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		 doGet(req, res);
	 }
	 
	 public void destroy() {
		 try {
			 if(ps!=null)
				 ps.close();
			 if(con!=null)
				 con.close();
		 }
		 catch (Exception e) {
			 e.printStackTrace();
		 }
		 
	 }
}
