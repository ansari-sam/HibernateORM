package com.OneToManyORManyToOne;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name="Question1")
@Table(name="Question_Details1")
public class Question {
	@Id
	@Column(name="quetion_Id")
	private int id;
	private String question;
	@OneToMany(mappedBy="question", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private List<Answer> answers;
	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Question(int id, String question, List<Answer> answers) {
		super();
		this.id = id;
		this.question = question;
		this.answers = answers;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public List<Answer> getAnswers() {
		return answers;
	}
	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}
	@Override
	public String toString() {
		return "Question [id=" + id + ", question=" + question + ", answers=" + answers + "]";
	}
	
	

}
