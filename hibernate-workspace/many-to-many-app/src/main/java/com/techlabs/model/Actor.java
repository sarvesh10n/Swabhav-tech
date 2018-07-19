package com.techlabs.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Actor {

	@Id
	@GeneratedValue
	private int id;
	private String name;

	@ManyToMany(mappedBy = "actorList")
	private Set<Movie> movieList = new HashSet<>();

	@Column(name="Actor_id")
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

	public Set<Movie> getMovieList() {
		return movieList;
	}

	public void setMovieList(Set<Movie> movieList) {
		this.movieList = movieList;
	}

}
