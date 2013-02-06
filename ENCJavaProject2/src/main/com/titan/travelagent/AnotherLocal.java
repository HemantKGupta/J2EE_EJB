package com.titan.travelagent;
import javax.ejb.Local;

@Local
public interface AnotherLocal
{
	public String sayHelloAnother(String name);
	 
}
