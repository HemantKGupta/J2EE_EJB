package com.hk.ejbs;
import javax.ejb.*; 
@Remote 
public interface SecondBean {
	public String sayHello(String name);
	public void rem();
	public String callAnother();
	public String callAnother2();
	 public String callAnother3();
}




