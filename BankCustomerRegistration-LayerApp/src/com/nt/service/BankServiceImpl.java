package com.nt.service;

import com.nt.bo.BankCustomerBO;
import com.nt.dao.BankCustomerDAO;
import com.nt.dao.BankCustomerDAOImpl;
import com.nt.dto.BankCustomerDTO;

public class BankServiceImpl implements BankService {
	BankCustomerDAO dao;
	
	public BankServiceImpl() {
		dao=new BankCustomerDAOImpl();
	}

	@Override
	public String registrationcustomer(BankCustomerDTO dto) throws Exception {
		BankCustomerBO bo;
		int count=0;
		float iniAmt=dto.getIniAmt(),cashback=0.0f,finalAmt=0.0f;
		if(iniAmt<100000) {
			cashback=1000.0f;
			finalAmt=cashback+iniAmt;
		}
		else {
			cashback=2000.0f;
			finalAmt=cashback+iniAmt;
		}
		bo=new BankCustomerBO();
		bo.setCusName(dto.getCusName());
		bo.setIniAmt(dto.getIniAmt());
		bo.setAccType(dto.getAccType());
		bo.setNationality(dto.getNationality());
		bo.setCashBackAmt(cashback);
		bo.setFinalAmt(finalAmt);
		count=dao.insertCustomer(bo);
		if(count==0)
			return "Registration fail";
		else
			return "Registration sucessful";
	}

}
