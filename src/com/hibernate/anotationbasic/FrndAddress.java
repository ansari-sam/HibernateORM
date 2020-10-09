package com.hibernate.anotationbasic;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

//@Entity
//@Table(name="Friend_Address")
@Embeddable //this will save this data into Friend table with all declare property
public class FrndAddress {
//	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	private int id;
	private String Street;
	@Column(length=40,name="Frnd_Village_city")
	private String City;
	private String State;
	@Column(name="Added_Date")
	@Temporal(TemporalType.DATE)
	private Date AddedDate;
	
	public FrndAddress() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FrndAddress(String street, String city, String state, Date addedDate) {
		super();
		Street = street;
		City = city;
		State = state;
		AddedDate = addedDate;
	}

	public String getStreet() {
		return Street;
	}

	public void setStreet(String street) {
		Street = street;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

	public String getState() {
		return State;
	}

	public void setState(String state) {
		State = state;
	}

	public Date getAddedDate() {
		return AddedDate;
	}

	public void setAddedDate(Date addedDate) {
		AddedDate = addedDate;
	}

	@Override
	public String toString() {
		return "FrndAddress [Street=" + Street + ", City=" + City + ", State=" + State + ", AddedDate="
				+ AddedDate + "]";
	}

	
	

}
