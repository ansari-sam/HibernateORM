package com.ManyToMany;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="Project_Details")
public class Project {
	@Id
	@Column(name="Project_ID")
	private int pid;
	@Column(name="Project_Name")
	private String pname;
	@ManyToMany(mappedBy="projects")
	private List<Emp> emps;
	public Project() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Project(int pid, String pname, List<Emp> emps) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.emps = emps;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public List<Emp> getEmps() {
		return emps;
	}
	public void setEmps(List<Emp> emps) {
		this.emps = emps;
	}
	@Override
	public String toString() {
		return "Project [pid=" + pid + ", pname=" + pname + ", emps=" + emps + "]";
	}
	

}
