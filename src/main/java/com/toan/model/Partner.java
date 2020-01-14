package com.toan.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="partner")
public class Partner {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="PartnerID")
	int partnerid;
	
//	@Column(name="LaborID")
//	int laborid;
	
	@Column(name="NameCompany")
	String namecompany;
	
	@Column(name="timeCoperate")
	String timework;

	@Column(name="Market")
	String market;
	
	@Column(name="AddressCompany")
	String addresscompany;
	
	@Column(name="Work")
	String work;
	
	@Column(name="TimeDuring")
	String timeduring;
	
	@Column(name="NumOfLaborNeed")
	int numneed;
	
	@Column(name="NumOfLaborGot")
	int numgot;
	
	@Column(name="Money")
	double money;
	
	public double getmoney() {
		return money;
	}

	public void setmoney(int money) {
		this.money = money;
	}

	public int getPartnerid() {
		return partnerid;
	}

	public void setPartnerid(int partnerid) {
		this.partnerid = partnerid;
	}

	/*
	 * public int getLaborid() { return laborid; }
	 */

//	public void setLaborid(int laborid) {
//		this.laborid = laborid;
//	}

	public String getNamecompany() {
		return namecompany;
	}

	public void setNamecompany(String namecompany) {
		this.namecompany = namecompany;
	}

	public String getTimework() {
		return timework;
	}

	public void setTimework(String timework) {
		this.timework = timework;
	}

	public String getMarket() {
		return market;
	}

	public void setMarket(String market) {
		this.market = market;
	}

	public String getAddresscompany() {
		return addresscompany;
	}

	public void setAddresscompany(String addresscompany) {
		this.addresscompany = addresscompany;
	}

	public String getWork() {
		return work;
	}

	public void setWork(String work) {
		this.work = work;
	}

	public String getTimeduring() {
		return timeduring;
	}

	public void setTimeduring(String timeduring) {
		this.timeduring = timeduring;
	}

	public int getNumneed() {
		return numneed;
	}

	public void setNumneed(int numneed) {
		this.numneed = numneed;
	}

	public int getNumgot() {
		return numgot;
	}

	public void setNumgot(int numgot) {
		this.numgot = numgot;
	}

	public Partner(int partnerid,  String namecompany, String timework, String market,
			String addresscompany, String work, String timeduring, int numneed, int numgot, double money) {
		super();
		this.partnerid = partnerid;
		//this.laborid = laborid;int laborid,
		this.namecompany = namecompany;
		this.timework = timework;
		this.market = market;
		this.addresscompany = addresscompany;
		this.work = work;
		this.timeduring = timeduring;
		this.numneed = numneed;
		this.numgot = numgot;
		this.money = money;
	}

	public Partner() {
		super();
	}

	

	
}
