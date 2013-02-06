package examples.stateless;

import javax.ejb.Stateless;

import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerService;
import javax.annotation.Resource;

@Stateless
public class HelloServiceBean implements HelloService {
	 @Resource javax.ejb.TimerService timerService;

	public String sayHello(String name) {
		timerService.createTimer(1000, null);
        return "Hello, "  + name;
    }
    @Timeout
    public void maintenance(Timer timer) {
    	
    	System.out.println("Time out called");
       
    }

}

