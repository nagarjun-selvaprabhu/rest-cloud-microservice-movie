package com.nagarjun.ReqSer.Dto;

public class Movie {
	public Movie(Integer id, String name, String lang, String genre) {
		this.id = id;
		this.name = name;
		this.lang = lang;
		this.genre = genre;
	}

	private Integer id;
	private String name;
	private String lang;
	private String genre;
	
	public Movie() {
		
	}
	
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

}
