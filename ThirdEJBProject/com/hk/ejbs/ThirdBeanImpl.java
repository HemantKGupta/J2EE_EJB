package com.hk.ejbs;

import javax.ejb.*; 
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless(name="Example", mappedName="ejb/ThirdBeanJNDI") 
public class ThirdBeanImpl implements ThirdBean {
	@PersistenceContext(name="my_persistence_ctx")
	EntityManager em;
    public String sayHello(String name) { 	
        return "Hello " + name + "!"; 	
    } 
    public void createCustomers() {
        Customer c1 = new Customer();
        c1.setId(1);
        c1.setName("XYZ");

        em.persist(c1); 	
    }
}
