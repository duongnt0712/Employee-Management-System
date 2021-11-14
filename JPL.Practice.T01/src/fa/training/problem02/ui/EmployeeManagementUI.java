package fa.training.problem02.ui;

import java.sql.Date;
import java.util.Scanner;

import fa.training.problem02.entities.Department;
import fa.training.problem02.entities.Employee;
import fa.training.problem02.entities.WorkingHistory;
import fa.training.problem02.services.DepartmentService;
import fa.training.problem02.services.EmployeeService;
import fa.training.problem02.services.WorkingHistoryService;

public class EmployeeManagementUI {
	
	public static void createMenu() {
		Scanner scanner = new Scanner(System.in);
		boolean userCheck= false;
		do {
			System.out.println("=======Employee Management System=======");
			System.out.println("1. Employee management");
			System.out.println("2. Department management");
			System.out.println("3. Close program");
			System.out.println("========================================");
			System.out.println("Please type the number of your option: [1]/[2]/[3]");
			int choice = scanner.nextInt();
			scanner.nextLine();
			String option = null;			
			
			switch(choice) {
				case 1: 
					// Employee management
					System.out.println("========================================");
					System.out.println("a. Add a new Employee");
					System.out.println("b. Update a specific Employee");
					System.out.println("c. Find an employee by emp_no");
					System.out.println("d. Add the working history");
					System.out.println("e. Find all the employees by working period of time");
					System.out.println("========================================");
					System.out.println("Please choose your option: [a]/[b]/[c]/[d]/[e]");
					option = scanner.nextLine();
					
					if(option.equalsIgnoreCase("a")) {
						addNewEmployee(scanner);
						userCheck = checkUserChoice(scanner);
						break;
					} else if(option.equalsIgnoreCase("b")) {
						updateEmployee(scanner);
						userCheck = checkUserChoice(scanner);
						break;
					} else if(option.equalsIgnoreCase("c")) {
						findEmployeeByEmpNo(scanner);
						userCheck = checkUserChoice(scanner);
						break;
					} else if(option.equalsIgnoreCase("d")) {
						addWorkingHistory(scanner);
						userCheck = checkUserChoice(scanner);
						break;
					} else if(option.equalsIgnoreCase("e")) {
						findAllByWorkingTime(scanner);
						userCheck = checkUserChoice(scanner);
						break;
					} else {
						System.err.println("Unexpected value: " + option + "!");
						userCheck = checkUserChoice(scanner);
						break;
					}	
				case 2:
					// Department management
					System.out.println("========================================");
					System.out.println("a. Add a new department");
					System.out.println("========================================");
					System.out.println("Please choose your option: [a]");
					option = scanner.nextLine();
					
					if(option.equalsIgnoreCase("a")) {
						addNewDepartment(scanner);
						userCheck = checkUserChoice(scanner);
						break;
					} else {
						System.err.println("Unexpected value: " + option + "!");
						userCheck = checkUserChoice(scanner);
						break;
					}
				case 3:
					System.out.println("Goodbye!");
					userCheck = false;
					break;
				default:
					System.out.println("Unexpected value: " + choice + "!");
					userCheck = checkUserChoice(scanner);
					break;
			}
				
		} while (userCheck);
		scanner.close();
	}
	
	private static void addNewEmployee(Scanner scanner) {
		EmployeeService employeeService = new EmployeeService();
		System.out.println("Enter employee birth date (yyyy-MM-dd): ");
		String birthDate = scanner.nextLine();
		System.out.println("Enter employee first name: ");
		String firstName = scanner.nextLine();
		System.out.println("Enter employee last name: ");
		String lastName = scanner.nextLine();
		System.out.println("Enter employee gender: ");
		String gender = scanner.nextLine();
		System.out.println("Enter employee hire date (yyyy-MM-dd): ");
		String hireDate = scanner.nextLine();
		Employee employee = new Employee(Date.valueOf(birthDate), firstName, lastName, gender.charAt(0), Date.valueOf(hireDate));
		
		employeeService.save(employee);
	}
	
	private static void updateEmployee(Scanner scanner) {
		EmployeeService employeeService = new EmployeeService();
		System.out.println("Enter employee id: ");
		int empNo = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter employee birth date (yyyy-MM-dd): ");
		String birthDate = scanner.nextLine();
		System.out.println("Enter employee first name: ");
		String firstName = scanner.nextLine();
		System.out.println("Enter employee last name: ");
		String lastName = scanner.nextLine();
		System.out.println("Enter employee gender: ");
		String gender = scanner.nextLine();
		System.out.println("Enter employee hire date (yyyy-MM-dd): ");
		String hireDate = scanner.nextLine();
		
		Employee employee = new Employee(empNo, Date.valueOf(birthDate), firstName, lastName, gender.charAt(0), Date.valueOf(hireDate));
		employeeService.update(employee);
		System.out.println("Updated successfully!");
	}
	
	private static void findEmployeeByEmpNo(Scanner scanner) {
		EmployeeService employeeService = new EmployeeService();
		System.out.println("Enter an ID to find: ");
		int empNo = scanner.nextInt();
		scanner.nextLine();
		
		employeeService.findById(empNo);
	}
	
	private static void addWorkingHistory(Scanner scanner) {
		WorkingHistoryService workingHistoryService = new WorkingHistoryService();
		System.out.println("Enter department id: ");
		int deptNo = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter employee id: ");
		int empNo = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the started date: ");
		String fromDate = scanner.nextLine();
		System.out.println("Enter the end date: ");
		String toDate = scanner.nextLine();
		WorkingHistory workingHistory = new WorkingHistory(deptNo, empNo, Date.valueOf(fromDate), Date.valueOf(toDate));
		
		workingHistoryService.addWorkingHistory(workingHistory);
	}
	
	private static void findAllByWorkingTime(Scanner scanner) {
		EmployeeService employeeService = new EmployeeService();
		System.out.println("Enter from date (yyyy-MM-dd): ");
		String fromDate = scanner.nextLine();
		System.out.println("Enter to date (yyyy-MM-dd): ");
		String toDate = scanner.nextLine();
		
		employeeService.findByWorkTime(Date.valueOf(fromDate), Date.valueOf(toDate));
	}
	
	private static void addNewDepartment(Scanner scanner) {
		DepartmentService departmentService = new DepartmentService();
		System.out.println("Enter department name: ");
		String deptNo = scanner.nextLine();
		System.out.println("Enter description for department: ");
		String description = scanner.nextLine();
		
		Department department = new Department(deptNo, description);
		departmentService.save(department);
		System.out.println("Added successfully!");
	}
	
	private static boolean checkUserChoice(Scanner scanner) {
		System.out.println("========================================");
		System.out.println("Do you want to continue? [Y]/[N]");
		String choice = scanner.nextLine();
		
		if (choice.equalsIgnoreCase("Y")) {
			return true;
		} else {
			System.out.println("Goodbye!");
			return false;
		}
	}
}
