package com.domain;

public class Author {
	private String email;

	public Author(String email) {
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
		return "(" + email + ")";
	}
	
}
