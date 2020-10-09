package com.hibernate.anotationbasic;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
//@Table(name="Friend_Details")
@Table(name="Friend_Details1")
public class Friend {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(length=40,name="Friend_name")
	private String name;
	@Column(length=50,name="Friend_Graduation_Branch")
	private String branch;
	private String email;
	private String Whatsapp_No;
	private FrndAddress frndAds;
	
	public Friend() {
	}
	public Friend(int id, String name, String branch, String email, String whatsapp_No, FrndAddress frndAds) {
		super();
		this.id = id;
		this.name = name;
		this.branch = branch;
		this.email = email;
		this.Whatsapp_No = whatsapp_No;
		this.frndAds=frndAds;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getWhatsapp_No() {
		return Whatsapp_No;
	}
	public void setWhatsapp_No(String whatsapp_No) {
		Whatsapp_No = whatsapp_No;
	}
	public FrndAddress getFrndAds() {
		return frndAds;
	}
	public void setFrndAds(FrndAddress frndAds) {
		this.frndAds = frndAds;
	}
	@Override
	public String toString() {
		return "Friend [id=" + id + ", name=" + name + ", branch=" + branch + ", email=" + email + ", Whatsapp_No="
				+ Whatsapp_No + ", frndAds=" + frndAds + "]";
	}
	
	
	
	

}
