package com.dao;

import org.apache.ibatis.session.SqlSession;

import com.domain.Author;
import com.util.ConnectionFactory;

public class AuthorDAO {
	
	public AuthorDAO() {
		
	}

	public void insertAuthor(Author author) {
		 
		SqlSession session = null;
		try {
			session = ConnectionFactory.getSqlSessionFactory().openSession();
			session.insert("com.mapper.CompanyMapper.insertAuthor",author);
			session.commit();
		} finally {
		  session.close();
		}	
	}

}
