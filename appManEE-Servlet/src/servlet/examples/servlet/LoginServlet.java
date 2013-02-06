package examples.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
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

import examples.model.Customer;
import examples.model.Address;

public class LoginServlet extends HttpServlet {

    
    
    @PersistenceUnit(unitName="EmployeeService")
    EntityManagerFactory emf;
	 @Resource UserTransaction tx;

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        printHtmlHeader(out);
        String userId = request.getParameter("user");
		if(userId!=null){				
            Customer cust = new Customer();           
            cust.setFirstName(userId);
			cust.setLastName("Gupta");
			     
			System.out.println("Hi"+userId);
			try {
                try {
                    tx.begin();
					EntityManager em = emf.createEntityManager();
					em.persist(cust);					
                    System.out.println("Hi"+userId);
					out.println("Customers:<br> ");
			        printCollection(em.createQuery("SELECT c FROM Customer c").getResultList(), out);
				    em.close();
				} finally {
						tx.commit();
					}
			} catch (Exception e) {
					// handle all the tx.begin()/commit() exceptions
					throw new EJBException(e);
				}
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
        out.println("<tr><td>User Id:</td><td><input type=\"text\" name=\"user\"/>(String)</td>");
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
