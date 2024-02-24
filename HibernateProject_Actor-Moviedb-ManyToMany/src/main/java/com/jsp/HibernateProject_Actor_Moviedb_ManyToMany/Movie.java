package com.jsp.HibernateProject_Actor_Moviedb_ManyToMany;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
@Entity
public class Movie {
	@Id
	private int movieId;
	private String movieTitle;
	private String movieGenre;
	private String movieDirector;
	private int boxOfficeCollection;
	private String boxOfficeVerdict;
	private String movieLanguage;
	@ManyToMany
	private List<Actor> alist;
	
	
	public List<Actor> getAlist() {
		return alist;
	}
	public void setAlist(List<Actor> alist) {
		this.alist = alist;
	}
	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public String getMovieTitle() {
		return movieTitle;
	}
	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}
	public String getMovieGenre() {
		return movieGenre;
	}
	public void setMovieGenre(String movieGenre) {
		this.movieGenre = movieGenre;
	}
	public String getMovieDirector() {
		return movieDirector;
	}
	public void setMovieDirector(String movieDirector) {
		this.movieDirector = movieDirector;
	}
	public int getBoxOfficeCollection() {
		return boxOfficeCollection;
	}
	public void setBoxOfficeCollection(int boxOfficeCollection) {
		this.boxOfficeCollection = boxOfficeCollection;
	}
	public String getBoxOfficeVerdict() {
		return boxOfficeVerdict;
	}
	public void setBoxOfficeVerdict(String boxOfficeVerdict) {
		this.boxOfficeVerdict = boxOfficeVerdict;
	}
	public String getMovieLanguage() {
		return movieLanguage;
	}
	public void setMovieLanguage(String movieLanguage) {
		this.movieLanguage = movieLanguage;
	}
	
	

}
