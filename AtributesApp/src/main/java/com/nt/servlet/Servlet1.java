package com.nt.servlet;

import java.io.IOException;

import javax.jws.WebService;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/s1url")
public class Servlet1 extends HttpServlet {
		public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			RequestDispatcher rd=null;
			HttpSession ses=null;
			ServletContext sc=null;
			//create request atribute
			req.setAttribute("attr1", "val1");
			//create sssion context atribute
			ses=req.getSession();
			ses.setAttribute("attr2", "val2");
			/*//create servlet context atribute
			sc=getServletContext();
			sc.setAttribute("attr3", "val3");
			//forward the request to servlet2 component
			*/
			rd=req.getRequestDispatcher("/s2url");
			rd.forward(req, res);
			
			
		}
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
