package examples.stateless;

import javax.ejb.SessionContext;
import javax.ejb.Stateful;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.interceptor.Interceptors;
import javax.annotation.Resource;
@Stateful
public class HelloServiceBean implements HelloService {
  @Resource SessionContext ctx;
	public String sayHello(String name) {
		
		System.out.println("Get Business object " + ctx.getInvokedBusinessInterface());
		System.out.println("Get Business object " + ctx.getBusinessObject(HelloService.class));
		
		return "Hello, "  + name;
    }
    
}

