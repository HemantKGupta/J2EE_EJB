package test.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.EJBException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.UserTransaction;

import test.entitites.*;

/**
 * Servlet implementation class for Servlet: TestServlet
 *
 */
 public class TestServlet extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;
   @PersistenceUnit(unitName="Work")
   EntityManagerFactory emf;
	@Resource UserTransaction tx;
   
    /* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public TestServlet() {
		super();
	}   	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 doPost(request, response);
	}  	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<body>");
        out.println("<html>");        
        out.println("<hr/>");
        out.println("<form action=\"TestServlet\" method=\"POST\">");
        out.println("<h3>Laptop Information</h3>");
        out.println("<table><tbody>");
        out.println("<tr><td>Laptop Name:</td><td><input type=\"text\" name=\"user\"/>(String)</td>");      
        out.println("<td><input name=\"action\" type=\"submit\" value=\"Login\"/></td></tr>");
        out.println("</tbody></table>");
        out.println("<hr/>"); 
 String user = request.getParameter("user"); 
        
		if(user!=null ){	
			Laptop l = new Laptop();
			l.setName(user);				
			try {                
                    tx.begin();
					EntityManager em = emf.createEntityManager();
					em.persist(l);	
					tx.commit();
					List<Laptop> list = (List)em.createQuery("SELECT l FROM Laptop l").getResultList();
					out.print("Names are :" + "<br/>");					
					for (Laptop lap : list){
						out.print(lap.getName()+" </br>");
					}				   
					em.close();				
			} catch (Exception e) {
					throw new EJBException(e);
				}
        }
		 out.println("</html>");
	     out.println("</body>");
	     out.close();
	}   	  	    
}