package com.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.domain.Participator;
import com.util.ConnectionFactory;

public class ParticipatorDAO {
	
	public ParticipatorDAO() {
		
	}
	
	public List<Participator> getParticipatorList() {
		List<Participator> partList = new ArrayList<Participator>();
		SqlSession session = null;
		try {
			session = ConnectionFactory.getSqlSessionFactory().openSession();
			partList = session.selectList("com.mapper.CompanyMapper.selectAllPartsEmail");
		} finally {
		  session.close();
		}
		return partList;
	}

	public void insertParticipator(Participator participator) {
		 
		SqlSession session = null;
		try {
			session = ConnectionFactory.getSqlSessionFactory().openSession();
			session.insert("com.mapper.CompanyMapper.insertParticipator",participator);
			session.commit();
		} finally {
		  session.close();
		}		
	}
	
}
