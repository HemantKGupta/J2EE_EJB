package examples.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.List;
import java.util.ArrayList;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import examples.stateless.OrgStructure;
import examples.model.Employee;

public class EmployeeServlet extends HttpServlet {

    private final String TITLE = 
        "Chapter 9: SqlResultSetMappings Example";
    
    private final String DESCRIPTION = 
        "This example demonstates various SqlResultSetMapping constructs.";

    
    @EJB
    OrgStructure orgStructure;
    
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        printHtmlHeader(out);
        
        // process request
        String action = request.getParameter("action");
        if (action == null) {
            // do nothing if no action requested
        } else if (action.equals("FindAll")) {
        	
            List emps = orgStructure.findAllEmployees(); 
            List<Employee> l = emps;
            out.println("Found All: <br/>");
            for(Employee e :l){
            	 out.println("Employee detail :" + e +"<br/>");
            }   
           
        } else if (action.equals("FindEmployeeWithAddress")) {
            List result = orgStructure.findEmployeeWithAddress();
            // ResultList will have Object[] of Employee and Address
            // All fields from each entity can be obtained as set in toString()
            out.println("Found All: <br/>");
            for (int i=0; i< result.size();i++){            	
                for (Object o2 : (Object[])result.get(i)) {
                    out.println("Entity name is : " + o2.getClass().getName() +" And data : " + o2 + " <br/>");
                }
                out.println("<br/>");
            }
            
        } else if (action.equals("FindEmployeeWithAddressColumnAlias")) {
            List emps = orgStructure.findEmployeeWithAddressColumnAlias();
            out.println("Found All: <br/>");
            printCollection(emps, out);
        } else if (action.equals("FindEmployeeWithManager")) {
            List emps = orgStructure.findEmployeeWithManager();
            // ResultList will have Object[] of String and String as set by ColumnResult
            out.println("Found Employees with Manager: <br/>");
            for (int i=0; i< emps.size();i++){            	
                for (Object o2 : (Object[])emps.get(i)) {
                    out.println("Column type is : " + o2.getClass().getName() +" And data : " + o2 + " <br/>");
                }
                out.println("<br/>");
            }
           
        } else if (action.equals("FindDepartmentSummary")) {
            List emps = orgStructure.findDepartmentSummary();
            out.println("Found Department Summaries: <br/>");
            printCollection(emps, out);
        }
        
        printHtmlFooter(out);
    }
    
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    private void printCollection(Collection c, PrintWriter out) {
        for (Object o : c) {
            if (o instanceof Object[]) {
                for (Object o2 : (Object[])o) {
                    out.println(o2 + " : ");
                }
                out.println("<br/>");
            } else {
                out.println(o + "<br/>");
            }
        }
    }
    
    private void printHtmlHeader(PrintWriter out) throws IOException {
        out.println("<body>");
        out.println("<html>");
        out.println("<head><title>" + TITLE + "</title></head>");
        out.println("<center><h1>" + TITLE + "</h1></center>");
        out.println("<p>" + DESCRIPTION + "</p>");
        out.println("<hr/>");
        out.println("<form action=\"EmployeeServlet\" method=\"POST\">");
        // form to create and Employee and Department
        out.println("<h3>Find Employees:</h3>");
        out.println("<table><tbody>");
        out.println("<tr><td><input name=\"action\" type=\"submit\" value=\"FindAll\"/></td></tr>");
        out.println("<tr><td><input name=\"action\" type=\"submit\" value=\"FindEmployeeWithAddress\"/></td></tr>");
        out.println("<tr><td><input name=\"action\" type=\"submit\" value=\"FindEmployeeWithAddressColumnAlias\"/></td></tr>");
        out.println("<tr><td><input name=\"action\" type=\"submit\" value=\"FindEmployeeWithManager\"/></td></tr>");
        out.println("<tr><td><input name=\"action\" type=\"submit\" value=\"FindDepartmentSummary\"/></td></tr>");
        out.println("</tbody></table>");
        out.println("<hr/>");
    }
    
    
    private void printHtmlFooter(PrintWriter out) throws IOException {
        out.println("</html>");
        out.println("</body>");
        out.close();
    }
}
