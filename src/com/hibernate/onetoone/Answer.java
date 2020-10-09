package com.hibernate.onetoone;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Answer_Details")
public class Answer {
	@Id
	private int id;
	private String answer;
	public Answer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Answer(int id, String answer) {
		super();
		this.id = id;
		this.answer = answer;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	
}
