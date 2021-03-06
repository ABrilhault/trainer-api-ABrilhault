package com.miage.altea.tp.trainer_api.bo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Trainer {

	@Id
	private String name;

	@OneToMany(cascade =  CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Pokemon> team;

	public Trainer() {
	}

	public Trainer(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Pokemon> getTeam() {
		return team;
	}

	public void setTeam(List<Pokemon> team) {
		this.team = team;
	}
}
