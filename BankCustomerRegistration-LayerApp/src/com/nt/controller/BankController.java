package com.nt.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nt.dto.BankCustomerDTO;
import com.nt.service.BankService;
import com.nt.service.BankServiceImpl;
import com.nt.vo.BankCustomerVO;
@WebServlet("/controller")
public class BankController extends HttpServlet {
	
	BankService service;
	public void init() {
		service=new BankServiceImpl() ;
	}

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	String name=null,add=null,iniAmt=null,Nat=null,accTy=null,result=null;
	BankCustomerVO vo=null;
	BankCustomerDTO dto=null;
	PrintWriter pw=null;
	name=req.getParameter("cname");
	add=req.getParameter("address");
	iniAmt=req.getParameter("inamt");
	Nat=req.getParameter("nat");
	accTy=req.getParameter("acctype");
	
	vo= new BankCustomerVO();
	vo.setCusName(name);
	vo.setCusAdd(add);
	vo.setAccType(accTy);
	vo.setIniAmt(iniAmt);
	vo.setNationality(Nat);
	
	dto=new BankCustomerDTO();
	dto.setCusName(vo.getCusName());
	dto.setCusAdd(vo.getCusAdd());
	dto.setIniAmt(Float.parseFloat(vo.getIniAmt()));
	dto.setAccType(vo.getAccType());
	dto.setNationality(vo.getNationality());
	
	pw=res.getWriter();
	res.setContentType("text/html");
	try {
		result=service.registrationcustomer(dto);
		pw.println(result);
	}
	catch (Exception e) {
		e.printStackTrace();
		pw.println("<h3>Intenal Problem</h3>");
		pw.println("<a href='form.html'>Home</a>");
	}
	pw.close();
	
	
	}
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
	public void destroy() {
		service=null;
	}

}
