package examples.stateless;

import javax.ejb.*;
import javax.persistence.EntityManager; 
import javax.persistence.PersistenceContext;
import javax.annotation.* ;

@Stateless
public class HelloServiceBean implements HelloService{
	@PersistenceContext  (unitName="EmployeeService")
	private EntityManager manager;	
	
    public String sayHello(String name) {
        return "Hello, "  + name;
    }
    public void createCabin(String name){
    	
        	Cabin cabin_1 = new Cabin( );
            cabin_1.setId(1);
            cabin_1.setName(name);
            cabin_1.setDeckLevel(1);
            cabin_1.setShipId(1);
            cabin_1.setBedCount(3);            
            manager.persist(cabin_1);
            // To test system exception when trxn started just before method dispatch
            throw new RuntimeException();
    	
    }  
   
    public void testCabin() {
    	Cabin c = manager.find(Cabin.class, 1);
    	System.out.println("obtained in another method " + c.getName());
    }
    

    
}

