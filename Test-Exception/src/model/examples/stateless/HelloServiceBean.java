package examples.stateless;

import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.annotation.security.DeclareRoles;
import javax.annotation.Resource;
import javax.ejb.SessionContext;

@Stateless

public class HelloServiceBean implements HelloService {
	//@Resource SessionContext ctx;

    public String sayHello(String name){
    	//throw new MyRuntimeAppException();
    	throw new RuntimeException();
    	//System.out.println("role is " );
       // return "Hello, "  + name;
    }
    
}

