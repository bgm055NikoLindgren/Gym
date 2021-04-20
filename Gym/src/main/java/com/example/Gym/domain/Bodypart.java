package com.example.Gym.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Bodypart {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long bodypartid;
private String bodypartName;

@JsonIgnore
@OneToMany(cascade = CascadeType.ALL, mappedBy = "bodypart")
private List<Exercise> exercises;

public Bodypart() {
	
}

public Bodypart(String bodypartName) {
	super();
	this.bodypartName = bodypartName;
}

public Long getBodypartid() {
	return bodypartid;
}

public void setBodypartid(Long bodypartid) {
	this.bodypartid = bodypartid;
}

public String getBodypartName() {
	return bodypartName;
}

public void setBodypartName(String bodypartName) {
	this.bodypartName = bodypartName;
}

public List<Exercise> getExercises() {
	return exercises;
}

public void setExercises(List<Exercise> exercises) {
	this.exercises = exercises;
}

@Override
public String toString() {
	return "id [id=" + bodypartid + ", bodypartName=" + bodypartName + "]";
}


}
