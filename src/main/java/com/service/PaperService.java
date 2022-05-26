package com.service;

import java.util.ArrayList;
import java.util.List;

import com.dao.PaperDAO;
import com.domain.Paper;

public class PaperService {
	public PaperService() {
		
	}
	
	public List<Paper> getPaperAbove7List() {
		List<Paper> paperList = new ArrayList<Paper>();
		PaperDAO paperDAO = new PaperDAO();
		paperList = paperDAO.getPaperAbove7List();
		return paperList;
	}
	
	public List<Paper> getPaperList() {
		List<Paper> paperList = new ArrayList<Paper>();
		PaperDAO paperDAO = new PaperDAO();
		paperList = paperDAO.getPaperList();
		return paperList;
	}
	
	public void insertPaper(Paper paper) {
		PaperDAO paperDAO = new PaperDAO();
		paperDAO.insertPaper(paper);
	}

}
