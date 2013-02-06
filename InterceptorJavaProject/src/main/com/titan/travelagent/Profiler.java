package com.titan.travelagent;

import javax.ejb.*;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;
import javax.annotation.Resource;
import javax.annotation.PostConstruct;

 
public class Profiler {
  
  @Resource EJBContext ctx;
  //@AroundInvoke 
  public Object profile(InvocationContext  invocation) throws Exception {
	 
      long startTime = System.currentTimeMillis( );
     try {
    	 System.out.println("caller principal is" +ctx.getClass().getName());
    	 System.out.println(" target is " + invocation.getTarget());
    	 System.out.println(" method is " + invocation.getMethod().getName());
         return invocation.proceed( );
     } finally {
        long endTime = System.currentTimeMillis( ) - startTime;
         System.out.println("Method " + invocation.getMethod( )
                           + " took " + endTime + " (ms)");     }
  }
  
  @PostConstruct
  public void bMethod(InvocationContext invocation){
	  System.out.println("In side interceptor");
	  try{
	  invocation.proceed( );
	 }
	  catch (Exception e){
		  e.printStackTrace();
	  }
  }
}

