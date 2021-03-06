package com.HQL;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="All_Student")
@Table(name="All_Student_Details")
public class Student_Details {
	@Id
	@Column(name="Student_ID")
	private int id;
	@Column(name="Student_Name")
	private String name;
	@Column(name="Student_City")
	private String City;
	public Student_Details() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student_Details(int id, String name, String city) {
		super();
		this.id = id;
		this.name = name;
		City = city;
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
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", City=" + City + "]";
	}

}
