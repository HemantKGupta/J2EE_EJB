package examples.servlet;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.ejb.EJBException;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.UserTransaction;

import examples.model.*;

public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	@PersistenceUnit(unitName="JoinedStrategy")
    EntityManagerFactory emf;
	 @Resource UserTransaction tx;

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        printHtmlHeader(out);
        
			Person p = new Person();
			
			p.setId(1);
		      p.setFirstName("Bill");
		      p.setLastName("Burke");
		     

		      Customer cust = new Customer();
		       cust.setId(2);
		      cust.setFirstName("Sacha");
		      cust.setLastName("Labourey");
		      cust.setStreet("Se La Vie");
		      cust.setCity("Neuchatel");
		      cust.setState("Switzerland");
		      cust.setZip("3332002-111");
		     
		      Employee employee = new Employee();
		      employee.setId(3);
		      employee.setFirstName("Gavin");
		      employee.setLastName("King");
		      employee.setStreet("1st Street");
		      employee.setCity("Atlanta");
		      employee.setState("GA");
		      employee.setZip("33320");
		      employee.setEmployeeId(15);

		      
			
			
			try {
                try {
                    tx.begin();
					EntityManager em = emf.createEntityManager();
					em.merge(p);
					em.merge(cust);
					em.merge(employee);
					em.flush();
					
					//	printCollection(em.createQuery("SELECT u FROM User u").getResultList(), out);
				em.close();
				} finally {
						tx.commit();
					}
			} catch (Exception e) {
					// handle all the tx.begin()/commit() exceptions
					throw new EJBException(e);
				}
        

        printHtmlFooter(out);
    }
    
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    private void printCollection(Collection c, PrintWriter out) {
        for (Object o : c) {
            out.print(o + "<br/>");
        }
    }
    
    private void printHtmlHeader(PrintWriter out) throws IOException {
        out.println("<body>");
        out.println("<html>");
        
        out.println("<hr/>");
        out.println("<form action=\"LoginServlet\" method=\"POST\">");
        // form to update
        out.println("<h3>Login User</h3>");
        out.println("<table><tbody>");
        //out.println("<tr><td>User Name:</td><td><input type=\"text\" name=\"user\"/>(String)</td>");
        //out.println("<tr><td>Employee Id:</td><td><input type=\"text\" name=\"empid\"/>(Integer)</td><br/>");
        out.println("<td><input name=\"action\" type=\"submit\" value=\"Login\"/></td></tr>");
        out.println("</tbody></table>");
        out.println("<hr/>");
    }
    
    
    private void printHtmlFooter(PrintWriter out) throws IOException {
        out.println("</html>");
        out.println("</body>");
        out.close();
    }
}

