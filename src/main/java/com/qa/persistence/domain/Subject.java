package com.qa.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class Subject {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Size(min = 1, max = 50)
	@NotNull
	private String title;

	@Pattern(regexp = "^([0-5]")
	private int score;

	@Column
	private long trainee_id;

	public Subject() {
	}

	public Subject(String title, int score, long id) {
		this.title = title;
		this.score = score;
		this.trainee_id = id;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public long getTraineeId() {
		return trainee_id;
	}

	public void setTraineeId(long trainee_id) {
		this.trainee_id = trainee_id;
	}

}
