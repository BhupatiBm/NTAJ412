package com.nt.servlet;



import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;
import com.ziclix.python.sql.connect.Connect;

import weblogic.jdbc.common.internal.DataSourceServiceImpl;



public class PoolServlet extends HttpServlet {
	private static final String STUDENT_INSERT_QUERRY="INSERT INTO STUDENT_RESULT VALUES(?,?,?,?,?,?,?,?)";
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		int sno=0;
		String sname=null,sadd=null,resul=null;
		float m1=0.0f,m2=0.0f,m3=0.0f,avg=0.0f;
		Connection con=null;
		PreparedStatement ps=null;
		int count=0;
		pw=res.getWriter();
		res.setContentType("text/html");
		sno=Integer.parseInt(req.getParameter("sno"));
		sname=req.getParameter("sname");
		sadd=req.getParameter("saddress");
		m1=Float.parseFloat(req.getParameter("m1"));
		m2=Float.parseFloat(req.getParameter("m2"));
		m3=Float.parseFloat(req.getParameter("m3"));
		
		try {
			avg=((m1+m2+m3)/3);
			
			if(avg<35)
				resul="FAIL";
			else
				resul="PASS";
			
			con=getPooledConnection();
			ps=con.prepareStatement(STUDENT_INSERT_QUERRY);
			ps.setInt(1, sno);
			ps.setString(2, sname);
			ps.setString(3, sadd);
			ps.setFloat(4, m1);
			ps.setFloat(5, m2);
			ps.setFloat(6, m3);
			ps.setFloat(7, avg);
			ps.setString(8, resul);
			
			count=ps.executeUpdate();
			if(count==0)
				pw.println("<h1 style='color: red;text-align: center;'>Registration Faile</h1>");
			else
				pw.println("<h1 style='color: green;text-align: center;'>Registration Done</h1>");
			pw.println("<br> <a href='input.html'>HOME</a>");
			
		}//try end
		catch (Exception e) {
			e.printStackTrace();
			pw.println("<h1 style='color: red;text-align: center;'>Internal Problem</h1>");
			
		}//catch end
		finally {
			try {
				if(ps!=null)
					ps.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
			try {
				if(con!=null)
					con.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
			try {
				if(pw!=null)
					pw.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}//get end
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
	
	private Connection getPooledConnection()throws Exception{
		ServletConfig cfg=null;
		Connection con=null;
		String jndi=null;
		InitialContext ic=null;
		DataSource ds=null;
		cfg=getServletConfig();
		jndi=cfg.getInitParameter("jndi");
		ic=new InitialContext();
		ds=(DataSource)ic.lookup(jndi);
		con=ds.getConnection();
		return con;
	}
	
	
	
	

	
}
