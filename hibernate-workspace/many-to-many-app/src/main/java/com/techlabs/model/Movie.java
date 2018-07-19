package com.techlabs.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.JoinColumn;


@Entity
public class Movie {

	@Id @GeneratedValue
	private int id;

	private String name;

	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(
	        name = "Movie_Actor", 
	        joinColumns = { @JoinColumn(name = "Movie_id") }, 
	        inverseJoinColumns = { @JoinColumn(name = "Actor_id") }
	    )
	private Set<Actor> actorList = new HashSet<>();

	@Column(name="Movie_id")
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

	public Set<Actor> getActorList() {
		return actorList;
	}

	public void setActorList(Set<Actor> actorList) {
		this.actorList = actorList;
	}

}
