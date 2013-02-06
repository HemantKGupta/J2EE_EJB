package com.hk.ejbs;
import javax.ejb.*; 
@Remote 
public interface ThirdBean {
	public String sayHello(String name);
	public void createCustomers();
}




