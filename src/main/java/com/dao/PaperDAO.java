package com.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.domain.Paper;
import com.util.ConnectionFactory;

public class PaperDAO {
	public PaperDAO() {
		
	}
	
	public List<Paper> getPaperAbove7List() {
		List<Paper> paperList = new ArrayList<Paper>();
		SqlSession session = null;
		try {
			session = ConnectionFactory.getSqlSessionFactory().openSession();
			paperList = session.selectList("com.mapper.CompanyMapper.selectPapersAbove7");
		} finally {
		  session.close();
		}
		return paperList;
	}
	
	public List<Paper> getPaperList() {
		List<Paper> paperList = new ArrayList<Paper>();
		SqlSession session = null;
		try {
			session = ConnectionFactory.getSqlSessionFactory().openSession();
			paperList = session.selectList("com.mapper.CompanyMapper.selectAllPapers");
		} finally {
		  session.close();
		}
		return paperList;
	}
	
	public void insertPaper(Paper paper) {
		 
		SqlSession session = null;
		try {
			session = ConnectionFactory.getSqlSessionFactory().openSession();
			session.insert("com.mapper.CompanyMapper.insertPaper",paper);
			session.commit();
		} finally {
		  session.close();
		}		
	}

}
