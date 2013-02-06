package examples.client;

import examples.stateless.HelloServiceRemote;
import javax.ejb.*;

public class Client {
    @EJB
    private static HelloServiceRemote helloService;
    
    public static void main(String[] args) {
        // a session bean with a Remote interface can be accessed
        // by a fat client
        System.out.println("######################");
        System.out.println("# " + helloService.sayHello("John"));
        System.out.println("######################");
    }
}

