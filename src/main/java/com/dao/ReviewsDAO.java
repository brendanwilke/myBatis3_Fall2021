package com.dao;

import org.apache.ibatis.session.SqlSession;

import com.domain.Reviews;
import com.util.ConnectionFactory;

public class ReviewsDAO {
	public ReviewsDAO() {
		
	}
	
	public void insertReview(Reviews review) {
		 
		SqlSession session = null;
		try {
			session = ConnectionFactory.getSqlSessionFactory().openSession();
			session.insert("com.mapper.CompanyMapper.insertReview",review);
			session.commit();
		} finally {
		  session.close();
		}		
	}

}
