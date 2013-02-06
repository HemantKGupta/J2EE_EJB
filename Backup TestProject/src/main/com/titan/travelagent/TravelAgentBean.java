package com.titan.travelagent;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.annotation.Resource;
import javax.sql.DataSource;
import javax.ejb.EJBException;
import java.sql.*;

import javax.ejb.*;

//@Stateless
public class TravelAgentBean implements TravelAgentRemote
{	
	@Resource(mappedName="java:/DefaultDS") DataSource dataSource;
	@Resource(name="min") int minCheckNumber;
	public String sayHello(String name)
    {
		Connection con = null;
        PreparedStatement ps = null;
        int customerID = 5;
        int amount = 100000;

        try {
            con = dataSource.getConnection( );
            ps = con.prepareStatement
                ("INSERT INTO Room (customer_id, amount) VALUES (?,?)");
            ps.setInt(1,customerID);
            ps.setInt(2,amount);
            
            int retVal = ps.executeUpdate( );
            if (retVal!=1) {
                throw new EJBException("Payment insert failed");
            }
           
        } catch(SQLException sql) {
            throw new EJBException(sql);
        } finally {
            try {
                if (ps != null) ps.close( );
                if (con!= null) con.close( );
            } catch(SQLException se) {
                se.printStackTrace( );
            }
        }

		
		
		
	return "Hi, "+ name + "\n  Resource is " + minCheckNumber;
    }
}
