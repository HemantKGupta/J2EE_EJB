package examples.stateless;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import examples.model.Employee;
import examples.model.LogRecord;

@Stateless
public class AuditServiceBean implements AuditService {
    @PersistenceContext(unitName="EmployeeService")
    private EntityManager em;
    
    /*The logTransaction() method in this example will inherit the transaction context from
    addEmployee() since its transaction attribute is the default REQUIRED and a transaction is active
    during the call to addEmployee(). When the find() method is invoked, the transaction-scoped
    entity manager checks for an active persistence context and will find the extended persistence
    context from the DepartmentManagerBean. It will then use this persistence context to execute the
    operation. All of the managed entities from the extended persistence context become visible to
    the transaction-scoped entity manager.*/
    
    public void logTransaction(int empId, String action) {
        // verify employee number is valid
        if (em.find(Employee.class, empId) == null) {
            throw new IllegalArgumentException("Unknown employee id");
        }
        LogRecord lr = new LogRecord(empId, action);
        em.persist(lr);
    }
}

