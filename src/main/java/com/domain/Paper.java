package com.domain;

public class Paper {
	private int paperid;
	private String title;
	private String filename;
	private String contactauthoremail;
	private String _abstract;
	
	public Paper() {
		
	}
	
	public Paper(int paperid, String title, String filename, String contactauthoremail, String _abstract) {
		super();
		this.paperid = paperid;
		this.title = title;
		this.filename = filename;
		this.contactauthoremail = contactauthoremail;
		this._abstract = _abstract;
	}
	
	public int getPaperid() {
		return paperid;
	}
	
	public void setPaperid(int paperid) {
		this.paperid = paperid;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getFilename() {
		return filename;
	}
	
	public void setFilename(String filename) {
		this.filename = filename;
	}
	
	public String getContactauthoremail() {
		return contactauthoremail;
	}
	
	public void setContactauthoremail(String contactauthoremail) {
		this.contactauthoremail = contactauthoremail;
	}
	
	public String get_abstract() {
		return _abstract;
	}
	
	public void set_abstract(String _abstract) {
		this._abstract = _abstract;
	}
	
	@Override
	public String toString() {
		return "Paper [paperid=" + paperid + ", title=" + title + ", filename=" + filename + ", contactauthoremail="
				+ contactauthoremail + ", abstract=" + _abstract + "]";
	}
	
	
	
}
