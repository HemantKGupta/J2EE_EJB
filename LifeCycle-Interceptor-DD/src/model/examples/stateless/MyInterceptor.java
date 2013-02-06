package examples.stateless;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.interceptor.InvocationContext;
public class MyInterceptor extends MySuperInterceptor{
	
	@PostConstruct
	public void cmethod (InvocationContext ctx) throws Exception {
	
		System.out.println("Inside Post Construct lifecycle callback from MyInterceptor class");
		ctx.proceed();
	}
	
	@PreDestroy
	public void dmethod(InvocationContext ctx) throws Exception  {
		System.out.println("Inside Pre destroy  lifecycle callback from MyInterceptor class");
		ctx.proceed();
	}
	
}