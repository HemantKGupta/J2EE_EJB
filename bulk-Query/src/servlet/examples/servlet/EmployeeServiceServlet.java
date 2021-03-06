package examples.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import examples.stateless.DepartmentService;
import examples.stateless.EmployeeService;
import examples.stateless.ProjectService;

public class EmployeeServiceServlet extends HttpServlet {

    private final String TITLE = 
        "Chapter 6: Bulk Query Examples";
    
    private final String DESCRIPTION = 
        "This example demonstrates bulk UPDATE and DELETE queries. </br>" +
        "The example allows you to update all employees' manager, remove " +
        "all empty projects, and delete all departments of a given name.";

    
    @EJB
    private EmployeeService empService;
    @EJB
    private ProjectService projService;
    @EJB
    private DepartmentService deptService;

    
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        printHtmlHeader(out);
        
        // process request
        String action = request.getParameter("action");
        if (action != null) {
            if (action.equals("UpdateManagers")) {
            	System.out.println("DeptId is " + request.getParameter("deptId"));
            	System.out.println("ManagerId is " + request.getParameter("mgrId"));
                empService.assignManager(
                        deptService.findDepartment(parseInt(request.getParameter("deptId"))),
                        empService.findEmployee(parseInt(request.getParameter("mgrId"))));
            } else if (action.equals("RemoveEmptyProjects")) {
                projService.removeEmptyProjects();
            } else if (action.equals("RemoveDepartmentsFailure")) {
                try {
                    deptService.removeDepartmentFailure();
                } catch (EJBException e) {
                    out.println("Unable to remove departments: " + e.getCause());
                    out.println("<hr/>");
                }
            } else if (action.equals("RemoveDepartments")) {
                deptService.removeDepartment();
            }
        }
        out.println("Employees:<br> ");
        printCollection(empService.findAllEmployees(), out);
        out.println("Departments:<br>");
        printCollection(deptService.findAllDepartments(), out);
        out.println("Projects:<br>");
        printCollection(projService.findAllProjects(), out);
        
        printHtmlFooter(out);
    }
    
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
       
    private int parseInt(String intString) {
        try {
            return Integer.parseInt(intString);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    private void printCollection(Collection c, PrintWriter out) {
        for (Object o : c) {
            out.print(o + "<br/>");
        }
    }
    
    private void printHtmlHeader(PrintWriter out) throws IOException {
        out.println("<body>");
        out.println("<html>");
        out.println("<head><title>" + TITLE + "</title></head>");
        out.println("<center><h1>" + TITLE + "</h1></center>");
        out.println("<p>" + DESCRIPTION + "</p>");
        out.println("<hr/>");
        out.println("<form action=\"EmployeeServiceServlet\" method=\"POST\">");
        // form to update
        out.println("<h3>Update Department Managers</h3>");
        out.println("This will set all employees' manager in the given department to the given manager.");
        out.println("<table><tbody>");
        out.println("<tr><td>Department Id:</td><td><input type=\"text\" name=\"deptId\"/>(int)</td></tr>");
        out.println("<tr><td>Manager Id:</td><td><input type=\"text\" name=\"mgrId\"/>(int)</td></tr>" +
                    "<td><input name=\"action\" type=\"submit\" value=\"UpdateManagers\"/></td></tr>");
        out.println("</tbody></table>");
        out.println("<hr/>");
        // form to remove empty projects
        out.println("<h3>Remove empty Projects</h3>");
        out.println("<table><tbody>");
        out.println("<tr><td><input name=\"action\" type=\"submit\" value=\"RemoveEmptyProjects\"/></td></tr>");
        out.println("</tbody></table>");
        out.println("<hr/>");
        // form to remove departments
        out.println("<h3>Remove Departments (with constraint failure)</h3>");
        out.println("<table><tbody>");
        out.println("<tr><td><input name=\"action\" type=\"submit\" value=\"RemoveDepartmentsFailure\"/></td></tr>");
        out.println("</tbody></table>");
        out.println("<hr/>");
        // form to remove departments
        out.println("<h3>Remove Departments</h3>");
        out.println("<table><tbody>");
        out.println("<tr><td><input name=\"action\" type=\"submit\" value=\"RemoveDepartments\"/></td></tr>");
        out.println("</tbody></table>");
        out.println("<hr/>");
    }
    
    
    private void printHtmlFooter(PrintWriter out) throws IOException {
        out.println("</html>");
        out.println("</body>");
        out.close();
    }
}
