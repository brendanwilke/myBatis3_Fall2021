package com.domain;

public class Writes {
	private int paperid;
	private String email;
	
	public Writes(int paperid, String email) {
		super();
		this.paperid = paperid;
		this.email = email;
	}

	public int getPaperid() {
		return paperid;
	}

	public void setPaperid(int paperid) {
		this.paperid = paperid;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Writes [paperid=" + paperid + ", email=" + email + "]";
	}
	
	
}
