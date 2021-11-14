package fa.training.problem02.services;

import fa.training.problem02.dao.impl.DepartmentDaoImpl;
import fa.training.problem02.dao.impl.EmployeeDaoImpl;
import fa.training.problem02.dao.impl.WorkingHistoryDaoImpl;
import fa.training.problem02.entities.Department;
import fa.training.problem02.entities.Employee;
import fa.training.problem02.entities.WorkingHistory;
import fa.training.problem02.exception.InvalidDateException;
import fa.training.problem02.utils.Validator;

public class WorkingHistoryService {
	private WorkingHistoryDaoImpl workingHistoryDaoImpl;
	private EmployeeDaoImpl employeeDaoImpl;
	private DepartmentDaoImpl departmentDaoImpl;
	
	public WorkingHistoryService() {
		workingHistoryDaoImpl = new WorkingHistoryDaoImpl();
		employeeDaoImpl = new EmployeeDaoImpl();
		departmentDaoImpl = new DepartmentDaoImpl();
	}
	
	public void addWorkingHistory(WorkingHistory workingHistory) {	
		if(!Validator.validateFromDateToDate(workingHistory.getFromDate(), workingHistory.getToDate())) {
			throw new InvalidDateException("To Date must be greater than From Date!");
		}
		int empNo = workingHistory.getEmpNo();
		int deptNo = workingHistory.getDeptNo();
		Employee employee = employeeDaoImpl.findById(empNo);
		Department department = departmentDaoImpl.findById(deptNo);
		if (employee == null) {
			System.out.println("Employee is not existed! Cannot add working history!");
		} else if (department == null){
			System.out.println("Department is not existed! Cannot add working history!");
		} else {
			workingHistoryDaoImpl.create(workingHistory);
			System.out.println("Added successfully!");
			System.out.println(workingHistory);
		}		
	}
}
