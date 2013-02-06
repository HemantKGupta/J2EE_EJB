package com.titan.travelagent;
import javax.ejb.Remote;

@Remote
public interface AnotherRemote
{
	public String sayHelloAnother(String name);
	 
}
