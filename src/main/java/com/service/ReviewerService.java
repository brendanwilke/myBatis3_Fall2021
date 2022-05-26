package com.service;

import java.util.ArrayList;
import java.util.List;

import com.dao.ReviewerDAO;
import com.domain.Reviewer;

public class ReviewerService {
	public ReviewerService() {
		
	}
	
	public List<Reviewer> getReviewerList() {
		List<Reviewer> reviewerList = new ArrayList<Reviewer>();
		ReviewerDAO reviewerDAO = new ReviewerDAO();
		reviewerList = reviewerDAO.getReviewerList();
		return reviewerList;
	}
	
	public void insertReviewer(Reviewer reviewer) {
		ReviewerDAO reviewerDAO = new ReviewerDAO();
		reviewerDAO.insertReviewer(reviewer);
	}

}
