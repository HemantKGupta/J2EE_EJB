package examples.stateless;

import java.util.Collection;

import examples.model.Employee;

public interface EmployeeService {
    public Employee newPersist(int id, String name, long salary);
    public Employee newMerge(int id, String name, long salary);
    public Employee newRefresh(int id, String name, long salary);
    public Employee newRemove(int id, String name, long salary);
    public Collection<Employee> findAllEmployees();
}
