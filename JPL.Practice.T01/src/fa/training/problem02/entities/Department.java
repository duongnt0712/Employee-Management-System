package fa.training.problem02.entities;

public class Department {
	private int deptNo;
	private String deptName;
	private String description;
	
	
	public Department(String deptName, String description) {
		super();
		this.deptName = deptName;
		this.description = description;
	}
	
	public Department(int deptNo, String deptName, String description) {
		super();
		this.deptNo = deptNo;
		this.deptName = deptName;
		this.description = description;
	}

	public int getDeptNo() {
		return deptNo;
	}

	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Department [deptNo=" + deptNo + ", deptName=" + deptName + ", description=" + description + "]";
	}
	
}
