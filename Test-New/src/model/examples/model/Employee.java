package examples.model;


import javax.persistence.*;

@Entity
public class Employee {
    @Id
    private int id;
    private String name;
    private long salary;

    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }
    @PrePersist void amethod(){
    	System.out.println(" PrePersist");
    }
    @PostPersist void bmethod(){
    	System.out.println(" PostPersist");
    }
    @PreRemove void cmethod(){
    	System.out.println(" PreRemove");
    }
    @PostRemove void dmethod(){
    	System.out.println(" PostRemove");
    }
    @PreUpdate void emethod(){
    	System.out.println(" PreUpdate");
    }
    @PostUpdate void fmethod(){
    	System.out.println(" PostUpdate");
    }    
    @PostLoad void gmethod(){
    	System.out.println(" PostLoad");
    }
    
    

    public String toString() {
        return "Employee id: " + getId() + " name: " + getName() + " salary: " + getSalary();
    }
}
