package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet("/s2url")
public class Servlet2 extends HttpServlet {
	@Resource(name="DsJndi")
	private DataSource ds=null;
	private static final String SINGLE_INPUT="INSERT INTO MARRIAGE VALUES(USER_ID.NEXTVAL,?,?,?,?,?,?,?)"; 
	private static final String MARRIED_INPUT="INSERT INTO MARRIAGE VALUES(USER_ID.NEXTVAL,?,?,?,?,?,?,?)"; 


		public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
				String name=null,fname=null,ms=null,wtm1=null,wtm2=null,sn=null,nc=null;
			Connection con=null;
			
			PreparedStatement ps=null;
			int count=0;
			
			PrintWriter pw=null;
			//get printwriter streem
			pw=res.getWriter();
			//set content type
			res.setContentType("text/html");
			//read hidden text data
			name=req.getParameter("hname");
			fname=req.getParameter("hfname");
			ms=req.getParameter("hms");
			if(ms.equalsIgnoreCase("single")) {
				wtm1=req.getParameter("wtm1");
				wtm2=req.getParameter("wtm2");
			}
			else {
				sn=req.getParameter("sn");
				nc=req.getParameter("nc");
			}
			try {
				
				//get pooled connection
				con=ds.getConnection();
				if(con!=null) {
					//generate preparedStatement
					if(ms.equalsIgnoreCase("single"))
						ps=con.prepareStatement(SINGLE_INPUT);
					else
						ps=con.prepareStatement(MARRIED_INPUT);
				}
				if(ps!=null) {
					ps.setString(1, name);
					ps.setString(2, fname);
					ps.setString(3, ms);
					if(ms.contentEquals("single")) {
						ps.setString(4, sn);
						ps.setString(5, nc);
						ps.setString(6, wtm1);
						ps.setString(7, wtm2);
					}
					else {
						ps.setString(4, sn);
						ps.setString(5, nc);
						ps.setString(6, wtm1);
						ps.setString(7, wtm2);
					}
				}
				count=ps.executeUpdate();	
				if(count==0)
					pw.println("<br><b>RECORD INSERTED </b><br>");
				else
					pw.println("<br><b>RECORD NOT INSERTED </b><br>");
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			pw.println("<br><h1>Form1 data"+name+" "+fname+" "+ms+"</h1");
			if(ms.equalsIgnoreCase("single"))
				pw.println("<br><h1>Form2 data"+wtm1+" "+wtm2+"</h1");
			else
				pw.println("<br><h1>Form2 data"+sn+" "+nc+"</h1");
			
			pw.close();
			}
	
			
			
		
		
		public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
		doGet(req, res);
	}

}
