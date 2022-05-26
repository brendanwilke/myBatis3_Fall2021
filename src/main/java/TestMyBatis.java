import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.dao.EmployeeDAO;
import com.domain.Employee;
import com.service.EmployeeService;

public class TestMyBatis {

	public static void main(String[] args) {
		List<Employee> empList = new ArrayList<Employee>();
		EmployeeService empService = new EmployeeService();
		List<HashMap<String,Object>> deptList;
		
		empList = empService.getEmpList();
		
		for(Employee e : empList)
			System.out.println(e);
		
		//System.out.println("List of employees whose salary is greater than 30000");
		//empList = empService.getEmpBySalary(new BigDecimal(70000));
		
		//for(Employee e : empList)
		//	System.out.println(e);
		
		// Demo of hashmap for getting all Departments
		//System.out.println("List of all Departments");
		//deptList = empService.getAllDepartments();
		
		/*
		for (HashMap<String,Object> d : deptList) {
			System.out.println("Dno:"+d.get("DNUMBER"));
			System.out.println("DName:"+d.get("DNAME"));
			
		}
		*/
		
		// Demo of hashmap for a generic query
		/*
		System.out.println("Generic Query Demo");
		deptList = empService.getAllDepartments();
		
		for (HashMap<String,Object> d : deptList) {
			System.out.println("ESSN:"+d.get("ESSN"));
			System.out.println("Number of Dependents:"+d.get("NUMBER_DEP"));
			
		}
		
		try {
			
			Employee e = new Employee("MyBatis","Lname","999", new BigDecimal(30000));
			empService.insertEmployee(e);			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("Employee inserted Successfully");
    	*/
	
	
	}

}
