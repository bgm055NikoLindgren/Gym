package com.example.Gym.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Exercise {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
private Long id;
private String move;
private int reps;
private int sets;
private String rest;

@ManyToOne
@JoinColumn(name = "bodypartid")
private Bodypart bodypart;

public Exercise() {}

public Exercise(String move, int reps, int sets, String rest, Bodypart bodypart) {
	super();
	this.move = move;
	this.reps = reps;
	this.sets = sets;
	this.rest = rest;
	this.bodypart = bodypart;
}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getMove() {
	return move;
}

public void setMove(String move) {
	this.move = move;
}

public int getReps() {
	return reps;
}

public void setReps(int reps) {
	this.reps = reps;
}

public int getSets() {
	return sets;
}

public void setSets(int sets) {
	this.sets = sets;
}

public String getRest() {
	return rest;
}

public void setRest(String rest) {
	this.rest = rest;
}

public Bodypart getBodypart() {
	return bodypart;
}

public void setBodypart(Bodypart bodypart) {
	this.bodypart = bodypart;
}

@Override
public String toString() {
	if (this.bodypart != null)
		return "Exercise [id=" + id + ", move=" + move + ", reps=" + reps + ", sets=" + sets + ", rest=" + rest + "department =" + this.getBodypart() + "]";
	
	else 
		return "Exercise [id=" + id + ", move=" + move + ", reps=" + reps + ", sets=" + sets + ", rest=" + rest + "]";
}







}
