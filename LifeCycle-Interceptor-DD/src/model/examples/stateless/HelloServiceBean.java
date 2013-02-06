package examples.stateless;

import javax.ejb.Stateless;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.interceptor.Interceptors;
@Interceptors(MyInterceptor.class)
@Stateless
public class HelloServiceBean implements HelloService {
    public String sayHello(String name) {
        return "Hello, "  + name;
    }
    @PostConstruct
    public void init(){
    	System.out.println("Inside Post Construct  lifecycle callback");
    }
    @PreDestroy
    public void init2(){
    	System.out.println("Inside Pre Destroy  lifecycle callback");
    }
}

