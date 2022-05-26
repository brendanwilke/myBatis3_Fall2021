package com.service;

import com.dao.ReviewsDAO;
import com.domain.Reviews;

public class ReviewsService {
	public ReviewsService() {
		
	}
	
	public void insertReview(Reviews review) {
		ReviewsDAO reviewsDAO = new ReviewsDAO();
		reviewsDAO.insertReview(review);
	}

}
