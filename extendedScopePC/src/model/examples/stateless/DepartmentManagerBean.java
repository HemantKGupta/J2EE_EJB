package examples.stateless;

import javax.ejb.EJB;
import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import examples.model.Department;
import examples.model.Employee;

@Stateful
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class DepartmentManagerBean implements DepartmentManager {
    @PersistenceContext(unitName="EmployeeService",
                        type=PersistenceContextType.EXTENDED)
    EntityManager em;
    Department dept;
    @EJB AuditService audit;

    public void init(int deptId) {
        dept = em.find(Department.class, deptId);
    }
    
    public Department getDepartment() {
        return dept;
    }

    public void setName(String name) {
        dept.setName(name);
    }
    /*The extended persistence context
    stored on the session bean will be immediately associated with the transaction when the
    method call starts. This will cause the relationship between the managed Department and
    Employee entities to be persisted to the database when the transaction commits. It also means
    that the extended persistence context will now be shared by other transaction-scoped persistence
    contexts used in methods called from addEmployee()*/
    
    public void addEmployee(int empId) {
        Employee emp = em.find(Employee.class, empId);
        dept.getEmployees().add(emp);
        emp.setDepartment(dept);
        audit.logTransaction(emp.getId(), 
                             "added to department " + dept.getName());
    }

    @Remove
    public void finished() {
    }
}

