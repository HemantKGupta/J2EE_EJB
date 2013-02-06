package examples.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.List;

import javax.ejb.EJBException;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.servlet.http.HttpServlet;
import javax.transaction.UserTransaction;
import examples.model.House;
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	@PersistenceUnit(unitName="Current")
    EntityManagerFactory emf;
	@Resource UserTransaction tx;

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        printHtmlHeader(out);        
        String userId = request.getParameter("user"); 
        
		if(userId!=null ){	
			House h = new House();
			h.setName(userId);				
			try {                
                    tx.begin();
					EntityManager em = emf.createEntityManager();
					em.persist(h);	
					tx.commit();
					List<House> l = (List)em.createQuery("SELECT h FROM House h").getResultList();
					out.print("Names are :" + "<br/>");					
					for (House hou : l){
						out.print(hou.getName()+" </br>");
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
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }    
    
    private void printHtmlHeader(PrintWriter out) throws IOException {
        out.println("<body>");
        out.println("<html>");
        
        out.println("<hr/>");
        out.println("<form action=\"LoginServlet\" method=\"POST\">");
        // form to update
        out.println("<h3>Login User</h3>");
        out.println("<table><tbody>");
        out.println("<tr><td>House Name:</td><td><input type=\"text\" name=\"user\"/>(String)</td>");      
        out.println("<td><input name=\"action\" type=\"submit\" value=\"Login\"/></td></tr>");
        out.println("</tbody></table>");
        out.println("<hr/>");
    }
    
 }

