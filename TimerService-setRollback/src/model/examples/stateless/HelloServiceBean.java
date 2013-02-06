package examples.stateless;

import javax.ejb.Stateless;

import javax.ejb.SessionContext;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerService;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.naming.Context;
import javax.annotation.Resource;
import javax.naming.InitialContext;

@Stateless
public class HelloServiceBean implements HelloService {
	@Resource javax.ejb.TimerService timerService;
	//@Resource SessionContext ctx;
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
	public String sayHello(String name) {
		timerService.createTimer(1000, null);
		
        return "Hello, "  + name;
    }
    @Timeout
    public void maintenance(Timer timer) {
    	System.out.println("Time out called before set rollback");
    	SessionContext sctx = null;
    	try{
    	Context ctx = new InitialContext();
    	 sctx = (SessionContext)ctx.lookup("java:comp/EJBContext");   
    	}catch (Exception e){
    		e.printStackTrace();
    	}
    	sctx.setRollbackOnly();    	
    	System.out.println("Time out called");
       
    }

}

