package examples.stateless;
import javax.ejb.*;
import javax.interceptor.*;
  
 public class SuperProfiler {
  @AroundInvoke 

   public Object aprofile(InvocationContext 
 invocation) throws
Exception {
     

      System.out.println(" Inside super");
       return invocation.proceed( );

        
         
      //}
   }
 }
