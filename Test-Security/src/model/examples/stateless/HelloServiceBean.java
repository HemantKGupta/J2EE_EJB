package examples.stateless;

import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.annotation.security.DeclareRoles;
import javax.annotation.Resource;
import javax.ejb.SessionContext;

@Stateless
@DeclareRoles("User")
public class HelloServiceBean implements HelloService {
	@Resource SessionContext ctx;
    public String sayHello(String name) {
    	System.out.println("role is " + ctx.isCallerInRole("User"));
        return "Hello, "  + name;
    }
}

