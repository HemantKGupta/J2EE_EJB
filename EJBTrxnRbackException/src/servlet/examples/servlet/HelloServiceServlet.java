package examples.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.annotation.*;
import javax.ejb.*;
import javax.transaction.*;

import examples.stateless.*;


public class HelloServiceServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
    @Resource UserTransaction utx;
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
    	response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<body>");
        out.println("<html>");
       
       
        out.println("<form action=\"HelloServiceServlet\" method=\"POST\">");
        out.println("<table><tbody>");
        out.println("<tr><td>Name:</td><td><input type=\"text\" name=\"name\"/></td></tr>");
        out.println("</tbody></table>");
        out.println("<input name=\"action\" type=\"submit\" value=\"Go\"/>");
        out.println("</form>");
        out.println("<hr/>");

        // if there was a name submitted, print the hello string
        String name = request.getParameter("name");
        if (name != null) {
            // lookup the HelloService
            HelloService service = null;
            try {
                service = (HelloService)
                    new InitialContext().lookup("java:comp/env/ejb/HelloService");
            } catch (Exception e) {
                throw new ServletException(e);
            }
            
           try{
            utx.begin();
            service.createCabin(name);
            utx.commit();
           }catch(javax.transaction.RollbackException e){
        	   e.printStackTrace();
           }catch(javax.transaction.NotSupportedException e){
        	   e.printStackTrace();
           }catch(javax.transaction.SystemException e){
        	   e.printStackTrace();
           }catch (javax.transaction.HeuristicMixedException e){
        	   e.printStackTrace();
           }catch(javax.transaction.HeuristicRollbackException e){
        	   e.printStackTrace();
           }
           // service.testCabin();
            out.println(service.sayHello(name));
        }

        out.println("</html>");
        out.println("</body>");
        out.close();
    }
}
