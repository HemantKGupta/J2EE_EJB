package com.titan.travelagent;

import javax.ejb.Remote;
import com.titan.domain.Cabin;


//@Remote
public interface TravelAgentRemote
{
	public String sayHello(String name);
	 public void createCabin(Cabin cabin);
	    public Cabin findCabin(int pKey);
}
