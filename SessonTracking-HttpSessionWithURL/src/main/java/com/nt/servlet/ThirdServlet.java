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
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

@WebServlet("/thirdurl")
public class ThirdServlet extends HttpServlet {
	@Resource(name="DsJndi")
	private DataSource ds=null;
	private static final String INSETR_INTO_TABLE="INSERT INTO JOB_TABLE VALUES(JOBID.NEXTVAL,?,?,?,?,?,?,?)";
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		PrintWriter pw=null;
		String city=null,salary=null;
		HttpSession session=null;
		String name=null,address=null,age=null,experience=null,skill=null;
		Connection con=null;
		PreparedStatement ps=null;
		int count=0;
		
		//get printwriter streem
		pw=res.getWriter();
		//set response content type
		res.setContentType("text/html");
		//read form 3 data
		city=req.getParameter("city");
		salary=req.getParameter("salary");
		//get access to session object
		session=req.getSession(false);
		//read form1/req1 and form2/req2 data
		name=(String) session.getAttribute("name");
		address=(String)session.getAttribute("address");
		age=(String)session.getAttribute("age");
		experience=(String)session.getAttribute("experience");
		skill=(String)session.getAttribute("skill");
		
		//insert form1 , form2, form3 data into data base
		try {
			//connect to the database
			con=ds.getConnection();
			//execute the querry
			ps=con.prepareStatement(INSETR_INTO_TABLE);
			ps.setString(1, name);
			ps.setString(2, age);
			ps.setString(3, address);
			ps.setString(4, experience);
			ps.setString(5, skill);
			ps.setString(6, city);
			ps.setString(7, salary);
			
			count=ps.executeUpdate();
			
			if(count!=0)
				pw.println("<h4 style='color:green; text-align:center;'>Inserted  Sucessfully</h4>");
			else
				pw.println("<h4 style='color:red; text-align:center;'>operation unsucessfull</h4>");
				
			pw.println("<a href='input.html'>home</a>");
		}
		catch(SQLException se) {
			se.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(con!=null)
					con.close();
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
			
			try {
				if(ps!=null)
					ps.close();
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
			
			
		}
		
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		doGet(req, res);
	}

}
