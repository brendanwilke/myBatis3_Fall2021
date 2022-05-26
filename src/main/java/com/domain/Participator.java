package com.domain;

public class Participator {
	private String email;
	private String firstname;
	private String minit;
	private String lastname;
	private String phone;
	private String affiliation;
	
	public Participator(String email, String firstname, String minit, String lastname, String phone,
			String affiliation) {
		super();
		this.email = email;
		this.firstname = firstname;
		this.minit = minit;
		this.lastname = lastname;
		this.phone = phone;
		this.affiliation = affiliation;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getMinit() {
		return minit;
	}

	public void setMinit(String minit) {
		this.minit = minit;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAffiliation() {
		return affiliation;
	}

	public void setAffiliation(String affiliation) {
		this.affiliation = affiliation;
	}

	@Override
	public String toString() {
		return "Participator [email=" + email + ", firstname=" + firstname + ", minit=" + minit + ", lastname="
				+ lastname + ", phone=" + phone + ", affiliation=" + affiliation + "]";
	}
	
	
	
}
