package com.nt.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.activation.MimeType;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.xml.internal.ws.api.message.Attachment;

import sun.security.util.Length;



/**
 * Servlet implementation class DownloadServlet
 */
@WebServlet("/downloadurl")
public class DownloadServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		ServletContext  sc=null;
		String path =null,filename=null;
		File file=null;
		String MimeType=null;
		InputStream is=null;
		OutputStream os=null;
		byte[] buffer;
		int bytesRead=0;
		sc=getServletContext();
		path=sc.getInitParameter("downloadpath");
		filename=req.getParameter("file");
		file =new File(path+"//"+filename);
		res.setContentLengthLong(file.length());
		MimeType=sc.getMimeType(file.getAbsolutePath());
		is=new FileInputStream(file);
		res.setHeader("context-disposition"," Attachment;filename=filename.getName()");
		os=res.getOutputStream();
		buffer=new byte[4096];
		while((bytesRead=is.read(buffer))!=-1 ) {
			os.write(buffer,0,bytesRead);
		}
		is.close();
		os.close();
		
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		doGet(req, res);
	}

}
