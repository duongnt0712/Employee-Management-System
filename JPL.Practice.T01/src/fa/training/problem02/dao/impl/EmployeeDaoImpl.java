package fa.training.problem02.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fa.training.problem02.dao.EmployeeDao;
import fa.training.problem02.entities.Employee;
import fa.training.problem02.utils.DBUtils;

public class EmployeeDaoImpl implements EmployeeDao{

	@Override
	public int create(Employee employee) {
		String sql = "INSERT INTO employee (birth_date, first_name, last_name, gender, hire_date) VALUES (?,?,?,?,?)";
		try (
			Connection connection = DBUtils.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			) {
			preparedStatement.setDate(1, employee.getBirthDate());
			preparedStatement.setString(2, employee.getFirstName());
			preparedStatement.setString(3, employee.getLastName());
			preparedStatement.setString(4, String.valueOf(employee.getGender()));
			preparedStatement.setDate(5, employee.getHireDate());
			return preparedStatement.executeUpdate();			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public List<Employee> findAll() {
		String sql = "SELECT*FROM employee";
		List<Employee> employees = new ArrayList<>();		
		try (
			Connection connection = DBUtils.getConnection();
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			) {
			while(rs.next()) {
				int empNo = rs.getInt("emp_no");
				Date birthDate = rs.getDate("birth_date");
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");
				char gender = rs.getString("gender").charAt(0);
				Date hireDate = rs.getDate("hire_date");
				employees.add(new Employee(empNo, birthDate, firstName, lastName, gender, hireDate));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employees;
	}

	public int update(Employee employee) {
		String sql = "UPDATE employee SET birth_date=?, first_name=?, last_name=?, gender=? , hire_date=?  WHERE emp_no = ?";
		try (
			Connection connection = DBUtils.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			) {
			preparedStatement.setDate(1, employee.getBirthDate());
			preparedStatement.setString(2, employee.getFirstName());
			preparedStatement.setString(3, employee.getLastName());
			preparedStatement.setString(4, String.valueOf(employee.getGender()));
			preparedStatement.setDate(5, employee.getHireDate());
			preparedStatement.setInt(6, employee.getEmpNo());
			return preparedStatement.executeUpdate();	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public Employee findById(int empNo) {
		Employee employee = null;
		String sql = "SELECT emp_no, birth_date, first_name, last_name, gender, hire_date from employee WHERE emp_no = ?";
		try (
			Connection connection = DBUtils.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(sql);			
			) {
			preparedStatement.setInt(1, empNo);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Date birthDate = rs.getDate("birth_date");
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");
				char gender = rs.getString("gender").charAt(0);
				Date hireDate = rs.getDate("hire_date");
				employee = new Employee(empNo, birthDate, firstName, lastName, gender, hireDate);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return employee;
	}
	
	public List<Employee> findByWorkTime(Date fromDate, Date toDate) {
		String sql = "SELECT e.emp_no, e.birth_date, e.first_name, e.last_name, e.gender, e.hire_date, wh.from_date, wh.to_date "
				+ "FROM (working_history AS wh INNER JOIN employee AS e ON wh.emp_no = e.emp_no) "
				+ "WHERE wh.from_date >= ? AND wh.to_date <= ?";
		List<Employee> employees = new ArrayList<>();
		try (
			Connection connection = DBUtils.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(sql);		
			) {
			preparedStatement.setString(1, fromDate.toString());
			preparedStatement.setString(2, toDate.toString());
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				int empNo = rs.getInt("emp_no");
				Date birthDate = rs.getDate("birth_date");
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");
				char gender = rs.getString("gender").charAt(0);
				Date hireDate = rs.getDate("hire_date");
				employees.add(new Employee(empNo, birthDate, firstName, lastName, gender, hireDate));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employees;
	}
}
