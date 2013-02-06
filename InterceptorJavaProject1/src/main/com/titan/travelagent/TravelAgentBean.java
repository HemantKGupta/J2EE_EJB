package com.titan.travelagent;

import javax.annotation.*;
import javax.interceptor.Interceptors;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;
import javax.ejb.*;

@Stateless
public class TravelAgentBean implements TravelAgentRemote
{	
	
	
	public String sayHello(String name)
    {
		
		return "Hi, "+ name ; 
		
    }
	@AroundInvoke
	   public Object beanClassInterceptor(InvocationContext ctx)throws Exception {
	      try {
	         System.out.println("entering: " + ctx.getMethod( ));
	         return ctx.proceed( );
	      }
	      
	      finally {	          
	           System.out.println("leaving Method ");
	           
	    }
	      
	      
	   }

	
	/*@PostConstruct
	public void aMethod(){
		System.out.println("Container called life cycle");
		
	}*/
	
	
	
}
