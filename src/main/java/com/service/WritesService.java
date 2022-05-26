package com.service;

import com.dao.WritesDAO;
import com.domain.Writes;

public class WritesService {
	public WritesService() {
		
	}
	
	public void insertWrites(Writes writes) {
		WritesDAO writesDAO = new WritesDAO();
		writesDAO.insertWrites(writes);
	}

}
