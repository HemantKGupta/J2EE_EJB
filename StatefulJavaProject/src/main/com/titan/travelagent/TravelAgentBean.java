package com.titan.travelagent;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.annotation.*;
import java.sql.*;
import com.titan.domain.Cabin;
import javax.ejb.*;



//@Stateless
public class TravelAgentBean implements TravelAgentRemote
{	
	String var = "";
	@Resource EJBContext ec;
	public String sayHello(String name)
    {
		//" SessionContext Resource gives " + sc.getBusinessObject(TravelAgentRemote.class);
		//EJBContext gives  " + ec.getCallerPrincipal().getName();
		var = var + name;
		return "Hi, "+ var ; 
		
    }
	
	
	    
	    
}
