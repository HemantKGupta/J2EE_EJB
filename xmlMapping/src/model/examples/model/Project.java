package examples.model;

import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.ManyToMany;

public class Project {
    protected int id;
    protected String name;
    //@ManyToMany(mappedBy="projects")
    private Collection employees;

    public Project() {
        employees = new ArrayList();
    }

    public int getId() {
        return id;
    }
    
    public void setId(int projectNo) {
        this.id = projectNo;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String projectName) {
        this.name = projectName;
    }
    
    public Collection getEmployees() {
        return employees;
    }
    
    public void setEmployees(Employee employee) {
        if (!getEmployees().contains(employee)) {
            getEmployees().add(employee);
        }
        if (!employee.getProjects().contains(this)) {
            employee.getProjects().add(this);
        }
    }
    
    public String toString() {
        return "Project id: " + getId() + ", name: " + getName() +
               " with " + getEmployees().size() + " employees";
    }
}
