package com.titan.travelagent;



import javax.annotation.*;


import javax.ejb.*;

@Stateless

public class AnotherBean implements AnotherLocal
{	
	public String sayHelloAnother(String name) {
		
		return "Hi, "+ name ; 
		
    }
	
	
}
