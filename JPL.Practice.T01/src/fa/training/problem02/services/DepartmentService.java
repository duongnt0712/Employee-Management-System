package fa.training.problem02.services;

import fa.training.problem02.dao.impl.DepartmentDaoImpl;
import fa.training.problem02.entities.Department;

public class DepartmentService {
	private DepartmentDaoImpl departmentDaoImpl;
	
	public DepartmentService() {
		departmentDaoImpl = new DepartmentDaoImpl();
	}
	
	public void save(Department department) {		
		departmentDaoImpl.create(department);
	}
}
