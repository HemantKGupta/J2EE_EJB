package com.titan.clients;

import com.titan.travelagent.TravelAgentRemote;
import com.titan.domain.Cabin;

import javax.naming.InitialContext;
import javax.naming.Context;
import javax.naming.NamingException;

import javax.rmi.PortableRemoteObject;
import java.util.Properties;

public class Client 
{
    public static void main(String [] args) 
    {
        try 
	{
            Context jndiContext = getInitialContext();
            Object ref = jndiContext.lookup("TravelAgentBean/remote");
            TravelAgentRemote bean = (TravelAgentRemote)ref;

            Cabin cabin_1 = new Cabin();
            cabin_1.setId(1);
            cabin_1.setName("My Suite");
            cabin_1.setDeckLevel(1);
            cabin_1.setShipId(1);
            cabin_1.setBedCount(3);

            bean.createCabin(cabin_1);

            Cabin cabin_2 = bean.findCabin(1);
            System.out.println(cabin_2.getName());
            System.out.println(cabin_2.getDeckLevel());
            System.out.println(cabin_2.getShipId());
            System.out.println(cabin_2.getBedCount());

        } 
        catch (javax.naming.NamingException ne)
        {
	    ne.printStackTrace();
	}
    }

    public static Context getInitialContext( )
    throws javax.naming.NamingException {

    Properties p = new Properties( );
    p.put(Context.INITIAL_CONTEXT_FACTORY,
        "org.jnp.interfaces.NamingContextFactory");
    p.put(Context.URL_PKG_PREFIXES,
        " org.jboss.naming:org.jnp.interfaces");
    p.put(Context.PROVIDER_URL, "jnp://localhost:1099");
    return new javax.naming.InitialContext(p);
}
}
