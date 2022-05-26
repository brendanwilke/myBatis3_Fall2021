package com.service;

import java.util.ArrayList;
import java.util.List;

import com.dao.ParticipatorDAO;
import com.domain.Participator;

public class ParticipatorService {

	public ParticipatorService() {
		
	}
	
	public List<Participator> getPartList() {
		List<Participator> partList = new ArrayList<Participator>();
		ParticipatorDAO partDAO = new ParticipatorDAO();
		partList = partDAO.getParticipatorList();
		return partList;
	}
	
	public void insertParticipator(Participator participator) {
		ParticipatorDAO empDAO = new ParticipatorDAO();
		empDAO.insertParticipator(participator);
			
	}
}
