package com.titan.travelagent;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.annotation.*;
import java.sql.*;

import javax.ejb.*;



//@Stateless
public class TravelAgentBean implements TravelAgentRemote
{	
	
	@Resource EJBContext ec;
	public String sayHello(String name)
    {
		//" SessionContext Resource gives " + sc.getBusinessObject(TravelAgentRemote.class);
		//EJBContext gives  " + ec.getCallerPrincipal().getName();
		return "Hi, "+ name ; 
		
    }
	//@PostConstruct
	public void myInit(){
		System.out.println("Initiated my session bean");
	}
}
