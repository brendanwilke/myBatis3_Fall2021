package com.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.domain.Reviewer;
import com.util.ConnectionFactory;

public class ReviewerDAO {
	public ReviewerDAO() {
		
	}
	
	public List<Reviewer> getReviewerList() {
		List<Reviewer> reviewerList = new ArrayList<Reviewer>();
		SqlSession session = null;
		try {
			session = ConnectionFactory.getSqlSessionFactory().openSession();
			reviewerList = session.selectList("com.mapper.CompanyMapper.selectAllReviewers");
		} finally {
		  session.close();
		}
		return reviewerList;
	}
	
	public void insertReviewer(Reviewer reviewer) {
		 
		SqlSession session = null;
		try {
			session = ConnectionFactory.getSqlSessionFactory().openSession();
			session.insert("com.mapper.CompanyMapper.insertReviewer",reviewer);
			session.commit();
		} finally {
		  session.close();
		}	
	}

}
