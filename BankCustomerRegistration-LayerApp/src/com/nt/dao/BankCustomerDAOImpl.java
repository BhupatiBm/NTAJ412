package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.nt.bo.BankCustomerBO;


public class BankCustomerDAOImpl implements BankCustomerDAO {
	private final static String CUSTOMER_TABLE="INSERT INTO LAYER_BANKCUSTOMER VALUES (BANK_CUST_SEQ.NEXTVAL,?,?,?,?,?,?)";
	
	private Connection getPooled()throws Exception{
		InitialContext ic=null;
		DataSource ds=null;
		Connection con=null;
		ic=new InitialContext();
		ds=(DataSource)ic.lookup("java:comp/env/DsJndi");
		con=(Connection) ds.getConnection();
		return con;
		
	}
	@Override
	public int insertCustomer(BankCustomerBO bo) throws Exception {
		Connection con=null;
		PreparedStatement ps=null;
		int count=0;
		con=getPooled();
		ps=con.prepareStatement(CUSTOMER_TABLE);
		ps.setString(1,bo.getCusName());
		ps.setFloat(2, bo.getIniAmt());
		ps.setString(3, bo.getNationality());
		ps.setString(4, bo.getAccType());
		ps.setFloat(5, bo.getCashBackAmt());
		ps.setFloat(6, bo.getFinalAmt());
		count=ps.executeUpdate();
		ps.close();
		con.close();
		
		return count;
	}

}
