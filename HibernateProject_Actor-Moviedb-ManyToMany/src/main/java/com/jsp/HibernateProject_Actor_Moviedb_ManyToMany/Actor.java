package com.jsp.HibernateProject_Actor_Moviedb_ManyToMany;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Actor {
	@Id
	private int actorId;
	private String actorName;
	private int actorAge;
	private String actorAddress;
	private String industry;
	private String nationality;
	@ManyToMany
	private List<Movie> mlist;
	
	public List<Movie> getList() {
		return mlist;
	}
	public void setList(List<Movie> list) {
		this.mlist = list;
	}
	public int getActorId() {
		return actorId;
	}
	public void setActorId(int actorId) {
		this.actorId = actorId;
	}
	public String getActorName() {
		return actorName;
	}
	public void setActorName(String actorName) {
		this.actorName = actorName;
	}
	public int getActorAge() {
		return actorAge;
	}
	public void setActorAge(int actorAge) {
		this.actorAge = actorAge;
	}
	public String getActorAddress() {
		return actorAddress;
	}
	public void setActorAddress(String actorAddress) {
		this.actorAddress = actorAddress;
	}
	public String getIndustry() {
		return industry;
	}
	public void setIndustry(String industry) {
		this.industry = industry;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	@Override
	public String toString() {
		return "Actor [actorId=" + actorId + ", actorName=" + actorName + ", actorAge=" + actorAge + ", actorAddress="
				+ actorAddress + ", industry=" + industry + ", nationality=" + nationality + ", mlist=" + mlist + "]";
	}
	
	

}
