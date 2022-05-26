package com.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.dao.EmployeeDAO;
import com.domain.Employee;

public class EmployeeService {
	
	public EmployeeService() {
		
	}

	public List<Employee> getEmpList() {
		List<Employee> empList = new ArrayList<Employee>();
		EmployeeDAO empDAO = new EmployeeDAO();
		empList = empDAO.getEmpList();
		return empList;
	}
	
	public List<Employee> getEmpBySalary(BigDecimal salary) {
		List<Employee> empList = new ArrayList<Employee>();
		EmployeeDAO empDAO = new EmployeeDAO();
		empList = empDAO.getEmpBySalary(salary);	
		
		return empList;
	}

	public List<HashMap<String,Object>> getAllDepartments() {
		List<HashMap<String,Object>> deptList;
		
		EmployeeDAO empDAO = new EmployeeDAO();
		deptList = empDAO.getAllDepartments();		
		return deptList;
	}
	
	public void insertEmployee(Employee employee) {
		EmployeeDAO empDAO = new EmployeeDAO();
		empDAO.insertEmployee(employee);
			
	}
	

}
