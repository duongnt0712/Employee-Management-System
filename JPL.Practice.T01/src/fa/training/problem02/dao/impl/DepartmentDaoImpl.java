package fa.training.problem02.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fa.training.problem02.dao.DepartmentDao;
import fa.training.problem02.dao.EmployeeDao;
import fa.training.problem02.entities.Department;
import fa.training.problem02.utils.DBUtils;

public class DepartmentDaoImpl implements DepartmentDao{

	@Override
	public int create(Department department) {
		String sql = "INSERT INTO department (dept_name, description) VALUES (?,?)";
		try (
			Connection connection = DBUtils.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			) {
			preparedStatement.setString(1, department.getDeptName());
			preparedStatement.setString(2, department.getDescription());
			return preparedStatement.executeUpdate();			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public Department findById(int deptNo) {
		Department department = null;
		String sql = "SELECT * FROM department WHERE dept_no = ?";
		try (
			Connection connection = DBUtils.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(sql);			
			) {
			preparedStatement.setInt(1, deptNo);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				String deptName = rs.getString("dept_name");
				String description = rs.getString("description");
				department = new Department(deptNo, deptName, description);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return department;
	}
	
}
