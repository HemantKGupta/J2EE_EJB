package com.hk.clients;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.rmi.PortableRemoteObject;

import com.hk.ejbs.FirstBean;

public class TestClient {

	
	public static void main(String[] args) {
		
		try {
			InitialContext ic = new InitialContext();
			Object first = ic.lookup("FirstBean");
			FirstBean fb = (FirstBean)PortableRemoteObject.narrow(first, FirstBean.class);
		    System.out.println(" Calling session bean ");
		    String result = fb.sayHello("Hemant");
		    System.out.println("After call "+result);
		    System.out.println("Adding an employee in db");
		    fb.addEmployee(2,"Hemant");
		    fb.addEmployee(3,"Rajni");
		    System.out.println("Check employee is added !");
		    
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
