package com.dao;

import org.apache.ibatis.session.SqlSession;

import com.domain.Writes;
import com.util.ConnectionFactory;

public class WritesDAO {
	public WritesDAO() {
		
	}
	
	public void insertWrites(Writes writes) {
		 
		SqlSession session = null;
		try {
			session = ConnectionFactory.getSqlSessionFactory().openSession();
			session.insert("com.mapper.CompanyMapper.insertWrites",writes);
			session.commit();
		} finally {
		  session.close();
		}		
	}

}
