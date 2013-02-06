package examples.stateless;

import java.util.Collection;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import examples.model.Employee;

@Stateless
public class EmployeeServiceBean implements EmployeeService {
    @PersistenceContext(unitName="EmployeeService")
    protected EntityManager em;

    public Employee newPersist(int id, String name, long salary) {
        Employee emp = new Employee();
        emp.setId(id);
        emp.setName(name);
        emp.setSalary(salary);
        em.persist(emp); 
        em.flush();
        // emp is a managed instance so merge will be ignored
        Employee e = em.merge(emp);
        // PreUpdate() will be called
        e.setName("hemant");
        // PostUpdate() will be called
        em.persist(e);        
        em.flush();
        //em.refresh(e);
      //  em.remove(e);
        return emp;
    }      
    public Employee newMerge(int id, String name, long salary) {
        Employee emp = new Employee();
        emp.setId(id);
        emp.setName(name);
        emp.setSalary(salary);
        em.merge(emp);        
        return emp;
    }
    
    public Employee newRefresh(int id, String name, long salary) {
        Employee emp = new Employee();
        emp.setId(id);
        emp.setName(name);
        emp.setSalary(salary);
        em.refresh(emp);        
        return emp;
    }
    
    public Employee newRemove(int id, String name, long salary) {
        Employee emp = new Employee();
        emp.setId(id);
        emp.setName(name);
        emp.setSalary(salary);
        em.remove(emp);        
        return emp;
    }
    
    public Collection<Employee> findAllEmployees() {
        Query query = em.createQuery("SELECT e FROM Employee e");
        return (Collection<Employee>) query.getResultList();
    }
}
