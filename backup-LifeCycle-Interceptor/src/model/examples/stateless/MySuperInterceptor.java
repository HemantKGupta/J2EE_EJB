package examples.stateless;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.interceptor.InvocationContext;
public class MySuperInterceptor {
	
	@PostConstruct
	public void amethod (InvocationContext ctx) throws Exception {
	
		System.out.println("Inside Post Construct lifecycle callback from MySuperInterceptor class");
		ctx.proceed();
	}
	
	@PreDestroy
	public void bmethod(InvocationContext ctx) throws Exception {
		System.out.println("Inside Pre destroy  lifecycle callback from MySuperInterceptor class");
		ctx.proceed();
	}
	
}