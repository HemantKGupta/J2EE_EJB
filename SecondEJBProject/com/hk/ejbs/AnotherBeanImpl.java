package com.hk.ejbs;

import javax.ejb.Stateless;

@Stateless(name="another")
public class AnotherBeanImpl implements AnotherBean{
	public String sayHi(){
		return "Hi";
		
	}

}
