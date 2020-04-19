package com.nt.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;





public class MarriageServlet extends HttpServlet {
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		PrintWriter pw=null;
		String pname=null,pgender=null,pjob_status=null,tage=null, flag=null;
		int page=0,psalary=0;
		List<String> list=null;
		//List <String> list=null;
		pw=res.getWriter();
		res.setContentType("text/html");
		pname=req.getParameter("name");
		tage=req.getParameter("age");
		list =new ArrayList();
		pgender=req.getParameter("gender");
		pjob_status=req.getParameter("job");
		psalary=Integer.parseInt(req.getParameter("salary"));
		flag=req.getParameter("pflag");
		
		/*pw.println(pname);
		pw.println(page);
		pw.println(pgender);
		pw.println(pjob_status);
		pw.println(psalary);*/
	
		if(flag.equalsIgnoreCase("no")) 
		{
		if(pname.length()==0  || pname.equalsIgnoreCase("") || pname==null) {
			list.add("<h3 style='color:red;text-align:center'>NAME is mandey tory</h3>");
		}
		if(tage.equalsIgnoreCase("") || tage.length()==0 || tage==null) 
		{
			list.add("<h3 style='color:red;text-align:center'>AGE is mandetory</h3>");
		}
		else
			{
				try {
					page=Integer.parseInt(tage);
					if(page<1 || page>125 ) {
						list.add("<h3 style='color:red;text-align:center'>AGE is must be 1 through 125</h3>");
						
					}
					
				} catch (NumberFormatException e) {
					list.add("<h3 style='color:red;text-align:center'>AGE must be numeric value</h3>");
				}
			}
		System.out.println(list.size());
		if(list.size()!=0) {
			for(String msg:list) 
				pw.println("<h3  style='color:red;text-align:center'>"+msg+"</h3>");
				return ;
			}
		}
		
		else
		{
			page=Integer.parseInt(tage);
		}
		if(pgender.equalsIgnoreCase("m"))
		{
			if(page>=22) 
			{
				if(pjob_status.equalsIgnoreCase("emp") )
				{
					if(psalary>=25000)
					{
					  pw.println("<h1 style='color:green;text-align:center'>Mr."+pname+" You are eligible for marriage...still think twice..it is a 60year project</h1>");
					}
					else
						pw.println("<h1 style='color:red;text-align:center'>Mr."+pname+" You are not eligible for marriage...earn salary 25k or more</h1>");
				}
				else
					pw.println("<h1 style='color:red;text-align:center'>Mr."+pname+" You are not eligible for marriage...find a JOB..enjy life</h1>");
		    }
			else
				pw.println("<h1 style='color:red;text-align:center'>Mr."+pname+" You are not eligible for marriage...you are uder age...enjoy your life..</h1>");
	    }
	else
		{
			if(page>=18) 
			{
				if(pjob_status.equalsIgnoreCase("emp")) 
				{
					pw.println("<h1 style='color:green;text-align:center'>Miss."+pname+" You are eligible for marriage...still think abot that boy</h1>");
				}
				else
					pw.println("<h1 style='color:red;text-align:center'>Miss."+pname+" You are not eligible for marriage...find a job and become indipendent yourself</h1>");
			}
			else
				pw.println("<h1 style='color:red;text-align:center'>Miss."+pname+" You are not eligible for marriage...you are under age</h1>");
		}
		pw.println("<a href='input.html'>Home</a>");
		pw.close();
		}
	}
	
