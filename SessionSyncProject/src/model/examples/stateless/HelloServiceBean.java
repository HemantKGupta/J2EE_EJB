package examples.stateless;

import javax.ejb.*;
import javax.persistence.EntityManager; 
import javax.persistence.PersistenceContext;
import javax.annotation.* ;
import java.rmi.RemoteException;


@Stateful


public class HelloServiceBean implements HelloService,javax.ejb.SessionSynchronization {
	@PersistenceContext  (unitName="EmployeeService")
	private EntityManager manager;
	
	
    public String sayHello(String name) {
        return "Hello, "  + name;
    }
    public void createCabin()throws Exception{
        	Cabin cabin_1 = new Cabin( );
            cabin_1.setId(1);
            cabin_1.setName("Master Suite");
            cabin_1.setDeckLevel(1);
            cabin_1.setShipId(1);
            cabin_1.setBedCount(3);
         
            manager.persist(cabin_1);
         
    }  
   
    public void testCabin() {
    	Cabin c = manager.find(Cabin.class, 1);
    	System.out.println("obtained in another method " + c.getName());
    }
    public void afterBegin() throws RemoteException{
    	System.out.println(" Inside after begin");
    }
    public void beforeCompletion() throws RemoteException{
    	System.out.println(" Inside before completion");
    }
    public void afterCompletion(boolean committed) throws RemoteException{
    	System.out.println(" Inside after completion");
    }

    
}

