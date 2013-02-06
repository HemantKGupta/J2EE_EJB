package com.titan.travelagent;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.annotation.*;
import javax.naming.InitialContext;
import javax.ejb.*;
@Stateless
/*@EJB(name="ejb/Another", 
		  beanInterface=AnotherLocal.class,
		     beanName="AnotherBean")*/

public class TravelAgentBean implements TravelAgentRemote
{	
	
	
	AnotherLocal ar;
	public String sayHello(String name) {
		/*AnotherLocal ar = null;
		try {
	         InitialContext ctx = new InitialContext( );
	          ar = (AnotherLocal)
	                 ctx.lookup("java:comp/env/ejb/Another");
	 

	      } catch (javax.naming.NamingException ne) {
	         throw new EJBException(ne);
	      }*/
	      name = name + ar.sayHelloAnother("Rajni");
		
		return "Hi, " + name ; 
		
    }
	
	
}
