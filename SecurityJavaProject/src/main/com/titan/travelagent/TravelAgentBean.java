package com.titan.travelagent;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.annotation.*;
import java.sql.*;

import javax.ejb.*;

//@Stateless
@Run
public class TravelAgentBean implements TravelAgentRemote
{		
	public String sayHello(String name)
    {	
		return "Hi, "+ name ; 
		
    }
	
}
