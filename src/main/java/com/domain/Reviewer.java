package com.domain;

public class Reviewer {
	private String email;

	public Reviewer(String email) {
		super();
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Reviewer [email=" + email + "]";
	}
	
	
}
