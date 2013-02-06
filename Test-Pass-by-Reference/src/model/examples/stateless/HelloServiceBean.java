package examples.stateless;

import java.util.Set;

import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.Remote;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.interceptor.Interceptors;
import javax.annotation.Resource;
//@Remote- adding this will result in pass by value so set will not retrive value added here in bean
@Stateless
public class HelloServiceBean implements HelloService {
 
  SessionContext ctx;
	public String sayHello(String name) {
		
		
		return "Hello, "  + name;
    }
	
	public Set go(Set s){
		s.add("GoodBye");
		return s;
	}
    
}

