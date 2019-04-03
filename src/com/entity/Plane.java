package com.entity;
//POJO¿‡
public class Plane {
	private String uname;
	private String sex;
	private String scity;
	private String dcity;
	private String date;
	private String ident;
	public Plane(){
		
	}
	public Plane(String uname,String sex,String scity,String dcity,String date,String ident){
		this.uname=uname;
		this.sex=sex;
		this.scity=scity;
		this.dcity=dcity;
		this.date=date;
		this.ident=ident;
		
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getScity() {
		return scity;
	}
	public void setScity(String scity) {
		this.scity = scity;
	}
	public String getDcity() {
		return dcity;
	}
	public void setDcity(String dcity) {
		this.dcity = dcity;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getIdent() {
		return ident;
	}
	public void setIdent(String ident) {
		this.ident = ident;
	}
	
}
