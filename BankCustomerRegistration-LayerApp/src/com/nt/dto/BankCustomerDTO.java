package com.nt.dto;

public class BankCustomerDTO {
	private String CusName;
	private String CusAdd;
	private float IniAmt;
	private String Nationality;
	private String AccType;
	public String getCusName() {
		return CusName;
	}
	public void setCusName(String cusName) {
		this.CusName = cusName;
	}
	public String getCusAdd() {
		return CusAdd;
	}
	public void setCusAdd(String cusAdd) {
		this.CusAdd = cusAdd;
	}
	public float getIniAmt() {
		return IniAmt;
	}
	public void setIniAmt(float iniAmt) {
		this.IniAmt = iniAmt;
	}
	public String getNationality() {
		return Nationality;
	}
	public void setNationality(String nationality) {
		this.Nationality = nationality;
	}
	public String getAccType() {
		return AccType;
	}
	public void setAccType(String accType) {
		this.AccType = accType;
	}
	
	

}
