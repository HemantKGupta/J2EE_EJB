package examples.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="EMPLOYEE", schema = "APP")
public class Employee extends Customer {
	 
	private static final long serialVersionUID = 1L;
	private int employeeId;
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}


}
