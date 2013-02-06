package com.titan.travelagent;

import javax.annotation.*;
import javax.interceptor.Interceptors;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;
import javax.ejb.*;

@Stateless
public class TravelAgentBean implements TravelAgentRemote
{	
	
	//@Interceptors(Profiler.class)
	public String sayHello(String name)
    {
		//" SessionContext Resource gives " + sc.getBusinessObject(TravelAgentRemote.class);
		//EJBContext gives  " + ec.getCallerPrincipal().getName();
		return "Hi, "+ name ; 
		
    }
	

	
	@PostConstruct
	public void aMethod(){
		System.out.println("Container called life cycle");
		
	}
	
	
	
}
