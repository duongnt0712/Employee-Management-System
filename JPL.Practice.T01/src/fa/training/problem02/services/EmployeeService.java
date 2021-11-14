package fa.training.problem02.services;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import fa.training.problem02.dao.impl.EmployeeDaoImpl;
import fa.training.problem02.entities.Employee;
import fa.training.problem02.entities.WorkingHistory;
import fa.training.problem02.exception.InvalidDateException;
import fa.training.problem02.utils.Validator;

public class EmployeeService {
	private EmployeeDaoImpl employeeDaoImpl;
	
	public EmployeeService() {
		employeeDaoImpl = new EmployeeDaoImpl();
	}
	
	public void save(Employee employee) {		
		employeeDaoImpl.create(employee);
		System.out.println(employee);
		System.out.println("Added successfully!");		
	}
	
	public List<Employee> findAll() {
		return employeeDaoImpl.findAll();
	}
	
	public void update(Employee employee) {
		employeeDaoImpl.update(employee);
		System.out.println(employee);
	}

	public void findById(int empNo)  {	 
		Employee employee = employeeDaoImpl.findById(empNo);
		if (employee == null) {
			System.out.println("No employee match with this ID.");
		} else {
			System.out.println(employee);
		}
	}
	
	public List<Employee> findByWorkTime(Date fromDate, Date toDate){
		if(!Validator.validateFromDateToDate(fromDate, toDate)) {
			throw new InvalidDateException("To Date must be greater than From Date");
		}
		List<Employee> employees = employeeDaoImpl.findByWorkTime(fromDate, toDate);
		if(employees == null) {
			System.out.println("No employee worked in this period!");
		} else {
			employees.forEach(e -> System.out.println(e));
		}
		
		return employees;
	}
}
