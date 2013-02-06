package examples.stateless;

import javax.ejb.*;
import javax.persistence.EntityManager; 
import javax.persistence.PersistenceContext;
import javax.annotation.* ;
import javax.transaction.UserTransaction;
import javax.ejb.TransactionManagementType;
import javax.ejb.TransactionManagement;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)

public class HelloServiceBean implements HelloService {
	@PersistenceContext  (unitName="EmployeeService")
	private EntityManager manager;
	
	@Resource UserTransaction ut;

	
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
            ut.begin();
            manager.persist(cabin_1);
            ut.commit();
    }
    
   
    public void testCabin() {
    	Cabin c = manager.find(Cabin.class, 1);
    	System.out.println("obtained in another method " + c.getName());
    }

    
}

