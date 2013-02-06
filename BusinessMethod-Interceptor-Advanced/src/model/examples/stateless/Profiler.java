package examples.stateless;
import javax.ejb.*;
import javax.interceptor.*;

public class Profiler extends SuperProfiler{
	@AroundInvoke 

	public Object profile(InvocationContext 
			invocation) throws
			Exception {
		long startTime = System.currentTimeMillis( );
		try {
			return invocation.proceed( );
		} finally {
			long endTime = System.currentTimeMillis( ) - startTime;
			System.out.println("Method " + invocation.getMethod( )
					+ " took " + endTime + " (ms)");
			System.out.println("Target class name " + invocation.getTarget().getClass().getName());
			System.out.println("Parameter  " + invocation.getParameters()[0]);
		}
	}
}
