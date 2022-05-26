package com.service;

import com.dao.AuthorDAO;
import com.domain.Author;

public class AuthorService {
	public AuthorService() {
		
	}
	
	public void insertAuthor(Author author) {
		AuthorDAO authorDAO = new AuthorDAO();
		authorDAO.insertAuthor(author);
	}
}
