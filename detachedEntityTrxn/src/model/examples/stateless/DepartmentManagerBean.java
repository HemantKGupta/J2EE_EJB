package examples.stateless;

import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import examples.model.Department;
import examples.model.Employee;

@Stateful
public class DepartmentManagerBean implements DepartmentManager {
    @PersistenceContext(unitName="EmployeeService")
    EntityManager em;
    Department dept;
    
    public void init(int deptId) {
        dept = em.find(Department.class, deptId);
               
    }
    
    public Department getDepartment() {
        return dept;
    }

    public void setName(String name) {
    	dept.setName(name);
    	
    	// after init() is executed , dept is a detached entity
        // EntityExistsException- detached entity can not persisted
        //em.persist(dept);
        //java.lang.IllegalArgumentException: Entity must be managed to call remove, refresh
        //em.remove(dept);
        //em.refresh(dept);
    }    

    public void addEmployee(int empId) {
        Employee emp = em.find(Employee.class, empId);
        dept.getEmployees().add(emp);
        emp.setDepartment(dept);
    }
    
    @Remove
    public void finished() {
    }
}

