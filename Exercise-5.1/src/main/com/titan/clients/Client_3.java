package com.titan.clients;

import com.titan.travelagent.TravelAgentRemote;
import com.titan.domain.Cabin;

import javax.naming.InitialContext;
import javax.naming.Context;
import javax.naming.NamingException;

import javax.rmi.PortableRemoteObject;
import java.util.Properties;
public class Client_3 
{
    public static void main(String [] args) 
    {
        try 
	{
            Context jndiContext = getInitialContext();
            Object ref = jndiContext.lookup("TravelAgentBean/remote");
            TravelAgentRemote dao = (TravelAgentRemote)ref;

            dao.flushModeExample();
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
