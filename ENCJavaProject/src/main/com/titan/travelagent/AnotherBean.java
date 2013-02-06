package com.titan.travelagent;



import javax.annotation.*;


import javax.ejb.*;
@Stateless(name="another",  mappedName="ejb/Another")
public class AnotherBean implements AnotherRemote
{	
	public String sayHelloAnother(String name) {
		
		return "Hi, "+ name ; 
		
    }
	
	
}
