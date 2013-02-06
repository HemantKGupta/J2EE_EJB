package com.hk.ejbs;

import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.ejb.*; 
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptors;
import javax.interceptor.InvocationContext;
import javax.naming.InitialContext;
import javax.naming.NamingException;

//@EJB(name="ejb/another", beanInterface=AnotherBean.class)
//@Interceptors(Profiler.class)
@Stateful(name="Example2", mappedName="ejb/SecondBeanJNDI") 
public class SecondBeanImpl implements SecondBean {
	
	String temp="Hi,";
	
    public String sayHello(String name) {
    	temp= temp+name;
        return temp; 	
    }
    
    public String callAnother() {
    	InitialContext ctx;
    	AnotherBean ab;
		try {
			ctx = new InitialContext();
			ab = (AnotherBean) ctx.lookup("java:comp/env/ejb/another");
		} catch (NamingException e) {
			throw new EJBException(e);
		}
    	
    	return "Hey!"+ab.sayHi();
	}
    
    @EJB(name="ejb/another", beanInterface=AnotherBean.class) AnotherBean a;
    public String callAnother2(){
    	return a.sayHi();
    	
    	
    }
    @Resource SessionContext EJBctx;
    public String callAnother3() {
    	AnotherBean	ab = (AnotherBean) EJBctx.lookup("ejb/another");		
    	
    	return "Hey!"+ab.sayHi();
	}
    
    /*@AroundInvoke
    public Object beanClassInterceptor(InvocationContext ctx) throws Exception{
       try {
          System.out.println("entering: " + ctx.getMethod( ));
          return ctx.proceed();
       } finally {
          System.out.println("leaving: " + ctx.getMethod( ));
       }
    }*/

    

	@Remove
	public void rem() {
		System.out.print("Removing should be done before to destroy");
		
	} 
    @PreDestroy
    private void dest(){
    	System.out.print("After removal");
    }
    
}
