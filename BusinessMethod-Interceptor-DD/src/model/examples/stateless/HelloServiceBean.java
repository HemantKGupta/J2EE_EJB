package examples.stateless;

import javax.ejb.Stateless;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.interceptor.Interceptors;
@Stateless
public class HelloServiceBean implements HelloService {
	
	
	public String sayHello(String name) {
        return "Hello, "  + name;
    }

}

