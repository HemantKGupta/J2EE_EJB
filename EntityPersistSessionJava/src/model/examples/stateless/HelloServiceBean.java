package examples.stateless;

import javax.ejb.*;
import javax.persistence.EntityManager; 
import javax.persistence.PersistenceContext;
import javax.annotation.* ;

@Stateless
public class HelloServiceBean implements HelloService {
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
            manager.flush();
            manager.clear();
            manager.persist(cabin_1);
    }  
    public void testDetach(){
    	Cabin c = manager.find(Cabin.class,1);
    	manager.persist(c);
    }
   
    

    
}

