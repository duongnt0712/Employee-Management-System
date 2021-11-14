package fa.training.problem02.entities;

import java.sql.Date;

public class WorkingHistory {
	private int deptNo;
	private int empNo;
	private Date fromDate;
	private Date toDate;

	public WorkingHistory() {
	}
	
	public WorkingHistory(int deptNo, int empNo, Date fromDate, Date toDate) {
		this.deptNo = deptNo;
		this.empNo = empNo;
		this.fromDate = fromDate;
		this.toDate = toDate;
	}

	public int getDeptNo() {
		return deptNo;
	}

	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}

	public int getEmpNo() {
		return empNo;
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	@Override
	public String toString() {
		return "WorkingHistory [deptNo=" + deptNo + ", empNo=" + empNo + ", fromDate=" + fromDate + ", toDate=" + toDate
				+ "]";
	}	
}
