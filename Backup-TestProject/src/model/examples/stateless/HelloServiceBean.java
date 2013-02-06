package examples.stateless;

import javax.ejb.Stateless;
import javax.persistence.EntityManager; 

import javax.persistence.PersistenceContext;




@Stateless
public class HelloServiceBean implements HelloService {
    public String sayHello(String name) {
        return "Hello, "  + name;
    }
    @PersistenceContext 
    (unitName="EmployeeService")
    private EntityManager manager;

        public void createCabin() {
        	Cabin cabin_1 = new Cabin( );
            cabin_1.setId(1);
            cabin_1.setName("Master Suite");
            cabin_1.setDeckLevel(1);
            cabin_1.setShipId(1);
            cabin_1.setBedCount(3);
            manager.persist(cabin_1);
        }

    
}

