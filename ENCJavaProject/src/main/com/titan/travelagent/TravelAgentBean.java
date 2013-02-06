package com.titan.travelagent;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.annotation.*;
import javax.naming.InitialContext;
import javax.ejb.*;
@Stateless
public class TravelAgentBean implements TravelAgentRemote
{	
	
	
	@EJB(name="ejb/Another" , beanInterface=AnotherRemote.class) AnotherRemote ar;
	public String sayHello(String name) {
		/*AnotherRemote ar = null;
		try {
	         InitialContext ctx = new InitialContext( );
	          ar = (AnotherRemote)
	                 ctx.lookup("java:comp/env/ejb/Another");
	 

	      } catch (javax.naming.NamingException ne) {
	         throw new EJBException(ne);
	      }*/
	      name = name + ar.sayHelloAnother("Rajni");
		
		return "Hi, " + name ; 
		
    }
	
	
}
