package com.toan.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="labor")
public class labor {

	@Id
	@Column(name="LaborID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int laborid;
	
	@Column(name="Name")
	String nameoflabor;

	@Column(name="Gender")	
	String gender;
	
	@Column(name="Born")
	String born;

	@Column(name="Address")	
	String address;
	
	@Column(name="Phone")
	String phone;

	@Column(name="Level")	
	String level;
		
	@Column(name="CompanyID")
	int companyid;

	public int getlaborid() {
		return laborid;
	}

	public void setlaborid(int laborid) {
		this.laborid = laborid;
	}

	public String getNameoflabor() {
		return nameoflabor;
	}

	public void setNameoflabor(String nameoflabor) {
		this.nameoflabor = nameoflabor;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBorn() {
		return born;
	}

	public void setBorn(String born) {
		this.born = born;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public int getCompanyid() {
		return companyid;
	}

	public void setCompanyid(int companyid) {
		this.companyid = companyid;
	}

	public labor( int laborid,String nameoflabor, String gender, String born, String address, String phone,
			String level, int companyid) {
		super();
		this.laborid=laborid;
		this.nameoflabor = nameoflabor;
		this.gender = gender;
		this.born = born;
		this.address = address;
		this.phone = phone;
		this.level = level;
		this.companyid = companyid;
	}

	public labor() {
		super();
	}
	

	
}
