package com.hk.ejbs;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
@Remote
@Stateless(name="First" ,mappedName="FirstBean")
public class FirstBeanImp implements FirstBean{

	@PersistenceContext(name="first_pu")
	EntityManager em;
	public String sayHello(String name) {
		System.out.println("Hi ! "+ name);
		return "Hi !"+ name ;
	}
	public void addEmployee(int id,String name){
		
		Employee emp = new Employee();
		emp.setId(id);
		emp.setName(name);
		em.persist(emp);
		
	}
	

}
