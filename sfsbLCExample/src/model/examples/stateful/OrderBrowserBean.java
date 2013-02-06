package examples.stateful;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.ejb.EJBException;
import javax.ejb.PostActivate;
import javax.ejb.PrePassivate;
import javax.ejb.Stateful;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import examples.model.Order;

@Stateful
@Resource(name="jdbc/__default", type=DataSource.class)
public class OrderBrowserBean implements OrderBrowser {
    DataSource ds;
    Connection conn;

    @PostConstruct
    public void init() {
        // acquire the data source
        try {
            ds = (DataSource)
                new InitialContext().lookup("java:comp/env/jdbc/__default");
            if(ds!=null){
            System.out.println("Got data source");
            }
        } catch (Exception e) {
            throw new EJBException(e);
        }
        acquireConnection();
    }
    
    @PrePassivate
    public void passivate() {
    	  System.out.println("Inside pre passivate");          
        releaseConnection();
    }

    @PostActivate
    public void activate() {
    	System.out.println("Inside post activate");  
        acquireConnection();
    }

    @PreDestroy
    public void shutdown() {
    	System.out.println("Inside pre destroy");  
        releaseConnection();
    }
    
    private void acquireConnection() {
        try {
            conn = ds.getConnection();
            System.out.println("Got connection");            
        } catch (SQLException e) {
            throw new EJBException(e);
        }
    }

    private void releaseConnection() {
        try {
            conn.close();
            System.out.println("Released connection");
            } catch (SQLException e) {
        }
        conn = null;
    }

    public Collection<Order> listOrders() {
        // ...
        return new ArrayList<Order>();
    }
}

