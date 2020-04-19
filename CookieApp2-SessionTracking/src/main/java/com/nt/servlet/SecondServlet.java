package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet("/secondurl")
public class SecondServlet extends HttpServlet {
	
	private static final String TAX_INPUT="INSERT INTO TAX_TAB VALUES(PID.NEXTVAL,?,?,?,?,?,?)";
	@Resource(name = "DsJndi")
	private  DataSource ds=null;
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String name=null,fname=null,ms=null,age=null;
		float  income=0.0f,tax=0.0f;
		Cookie[] ck=null;
		PreparedStatement ps=null;
		int count=0;
		//Cookie ck[]=null;
		Connection con=null;
		PrintWriter pw=null;
		pw=res.getWriter();
		res.setContentType("text/html");
		//read form2 data
		income=Float.parseFloat(req.getParameter("income"));
		tax=Float.parseFloat(req.getParameter("tax"));
		//read form1 data/cookies
		ck=req.getCookies();
		if(ck!=null) {
			name=ck[0].getValue();
			fname=ck[1].getValue();
			age=ck[2].getValue();
			ms=ck[3].getValue();		
		}
		//use jdbc to store data
		
		try {
			con=ds.getConnection();
			ps=con.prepareStatement(TAX_INPUT);
			ps.setString(1, name);
			ps.setString(2,fname);
			ps.setString(3,age);
			ps.setString(4,ms);
			ps.setFloat(5,income);
			ps.setFloat(6,tax);
			count=ps.executeUpdate();
			if (count!=0)
				pw.println("<b>insert successfully<br>");
			else
				pw.println("<b> ubsuccessful..............soyyr<br>");
				
		}//try
		catch (Exception e) {
		e.printStackTrace();
		}
		finally {
			try {
				if(ps!=null)
					ps.close();
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
			
			try {
				if(con!=null)
					con.close();
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
			
		}
		pw.println("<b>"+ms);
		pw.println("<b>::::::form1 data::::::::::"+name+"  "+fname+"  "+age+"  "+ms+"<br>" );
		pw.println("<b>::::::form2 data::::::::::"+income+"   "+tax);
		
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
