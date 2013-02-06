package examples.stateless;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.interceptor.InvocationContext;
public class MyInterceptor1 {
	
	@PostConstruct
	public void emethod (InvocationContext ctx) throws Exception {
	
		System.out.println("Inside Post Construct lifecycle callback from MyInterceptor1 class");
		ctx.proceed();
	}
	
	@PreDestroy
	public void fmethod(InvocationContext ctx) throws Exception {
		System.out.println("Inside Pre destroy  lifecycle callback from MyInterceptor1 class");
		ctx.proceed();
	}
	
}