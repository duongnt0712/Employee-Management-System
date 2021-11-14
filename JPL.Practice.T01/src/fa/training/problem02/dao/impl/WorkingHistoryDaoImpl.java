package fa.training.problem02.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fa.training.problem02.dao.WorkingHistoryDao;
import fa.training.problem02.entities.Employee;
import fa.training.problem02.entities.WorkingHistory;
import fa.training.problem02.utils.DBUtils;

public class WorkingHistoryDaoImpl implements WorkingHistoryDao {

	@Override
	public int create(WorkingHistory workingHistory) {
		String sql = "INSERT INTO working_history (dept_no, emp_no, from_date, to_date) VALUES (?,?,?,?)";
		try (
			Connection connection = DBUtils.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			) {
			preparedStatement.setInt(1, workingHistory.getDeptNo());
			preparedStatement.setInt(2, workingHistory.getEmpNo());
			preparedStatement.setDate(3, workingHistory.getFromDate());
			preparedStatement.setDate(4, workingHistory.getToDate());
			return preparedStatement.executeUpdate();			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
}
