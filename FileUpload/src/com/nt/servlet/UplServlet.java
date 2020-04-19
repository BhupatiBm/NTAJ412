package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.xalan.internal.xsltc.runtime.Hashtable;

import javazoom.upload.MultipartFormDataRequest;
import javazoom.upload.UploadBean;
import javazoom.upload.UploadFile;


@WebServlet("/UplServlet")
public class UplServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		MultipartFormDataRequest nreq=null;
		UploadBean bean=null;
		Enumeration<UploadFile>e=null;
		java.util.Hashtable<String, UploadFile> map=null;
		pw=res.getWriter();
		res.setContentType("text/html");
		try {
			nreq=new MultipartFormDataRequest(req);
			bean=new UploadBean();
			bean.setFolderstore("f:/store");
			bean.setOverwrite(false);
			bean.store(nreq);
			pw.println("<h1 style='text-align: center;'><b>The Uploaded File Are..</h1>");
			map=nreq.getFiles();
			e=map.elements();
			while (e.hasMoreElements()) {
				UploadFile file = (UploadFile) e.nextElement();
				pw.println("<br>"+file.getFileName()+","+file.getFileSize()+","+file.getContentType());	
			}
		}
		catch (Exception ex) {
			ex.printStackTrace();
			pw.println("<a href='upload.html'>Home</a>");
		}
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
