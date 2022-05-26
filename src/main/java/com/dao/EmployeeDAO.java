package com.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.domain.Employee;
import com.util.ConnectionFactory;

public class EmployeeDAO {
	
	public EmployeeDAO() {
		
	}

	public List<Employee> getEmpList() {
		List<Employee> empList = new ArrayList<Employee>();
		SqlSession session = null;
		try {
			session = ConnectionFactory.getSqlSessionFactory().openSession();
			empList = session.selectList("com.mapper.CompanyMapper.selectAll");
		} finally {
		  session.close();
		}
		return empList;
	}
	

	public List<Employee> getEmpBySalary(BigDecimal salary) {
		List<Employee> empList = new ArrayList<Employee>();
		SqlSession session = null;
		try {
			session = ConnectionFactory.getSqlSessionFactory().openSession();
			empList = session.selectList("com.mapper.CompanyMapper.selectEmpBySalary",salary);
		} finally {
		  session.close();
		}
		return empList;
	}
	
	public List<HashMap<String,Object>> getAllDepartments() {
		List<HashMap<String,Object>> deptList; 
		SqlSession session = null;
		try {
			session = ConnectionFactory.getSqlSessionFactory().openSession();
			deptList = session.selectList("com.mapper.CompanyMapper.selectAllDepartments");
		} finally {
		  session.close();
		}
		return deptList;
	}
	
	public void insertEmployee(Employee employee) {
		 
		SqlSession session = null;
		try {
			session = ConnectionFactory.getSqlSessionFactory().openSession();
			session.insert("com.mapper.CompanyMapper.insertEmployee",employee);
			session.commit();
			
		} finally {
		  session.close();
		}		
	}


	
	

}
