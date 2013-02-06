package com.hk.ejbs;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class Profiler {
	
	@AroundInvoke 
	public Object profile(InvocationContext invocation) throws 	Exception {
	     long startTime = System.currentTimeMillis( );
	    try {
	       return invocation.proceed( );
	     } finally {
	        long endTime = System.currentTimeMillis( ) - startTime;
	       System.out.println("Method " + invocation.getMethod( )
	                         + " took " + endTime + " (ms)");
	     }
	 }


}
