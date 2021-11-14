package fa.training.problem02.test;

import java.sql.Date;
import java.util.Scanner;

import fa.training.problem02.dao.impl.EmployeeDaoImpl;
import fa.training.problem02.entities.WorkingHistory;
import fa.training.problem02.services.EmployeeService;
import fa.training.problem02.services.WorkingHistoryService;
import fa.training.problem02.ui.EmployeeManagementUI;
import fa.training.problem02.utils.Validator;

public class EmployeeManagementAppTest {
	private static final WorkingHistoryService workingHistoryService = new WorkingHistoryService();
	private static final EmployeeService employeeService = new EmployeeService();
	private static final EmployeeDaoImpl employeeDaoImpl = new EmployeeDaoImpl();
	public static void main(String[] args) throws Exception{
//		WorkingHistory workingHistory = new WorkingHistory();
//		workingHistoryService.addWorkingHistory(workingHistory);
//		int empNo = 0;
//		employeeService.findById(empNo);
		Date a = Date.valueOf("2021-11-04");
		Date b = Date.valueOf("2021-11-05");
		
		System.out.println(b.compareTo(a));
		
//		System.out.println(employeeService.findByWorkTime(a, b));
	}
}
