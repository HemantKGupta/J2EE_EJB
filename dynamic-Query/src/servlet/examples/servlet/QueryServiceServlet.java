package examples.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import examples.model.Employee;
import examples.stateless.QueryService;

public class QueryServiceServlet extends HttpServlet {
    @EJB
    private QueryService service;
        
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        printHtmlHeader(out);
        String action = request.getParameter("action");
        if (action != null) {
            if (action.equals("Find")) {
                long salary = service.queryEmpSalary(
                        request.getParameter("deptName"),
                        request.getParameter("empName"));
                out.println("Found Salary: " + salary);
                out.println("<hr/>");
            } else if (action.equals("FindUsingParams")) {
                long salary = service.queryEmpSalaryUsingParams(
                        request.getParameter("deptName"),
                        request.getParameter("empName"));
                out.println("Found Salary: " + salary);
                out.println("<hr/>");
            }
        }
        out.println("All Employees:<br> ");
        for (Employee emp : service.findAllEmployees()) {
            out.print(emp + "<br/>");
        }
        
        printHtmlFooter(out);
    }
    
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
    
    private void printHtmlHeader(PrintWriter out) throws IOException {
        out.println("<body>");
        out.println("<html>");
       
        out.println("<form action=\"QueryServiceServlet\" method=\"POST\">");
        // form find
        out.println("<h3>Find Employee Salary</h3>");
        out.println("<table><tbody>");
        out.println("<tr><td>Employee Name:</td><td><input type=\"text\" name=\"empName\"/>(String)</td></tr>");
        out.println("<tr><td>Department Name:</td><td><input type=\"text\" name=\"deptName\"/>(String)</td></tr>");
        out.println("<tr><td><input name=\"action\" type=\"submit\" value=\"Find\"/></td>");
        out.println("<td><input name=\"action\" type=\"submit\" value=\"FindUsingParams\"/></td></tr>");
        out.println("</tbody></table>");
        out.println("<hr/>");
    }
    
    
    private void printHtmlFooter(PrintWriter out) throws IOException {
        out.println("</html>");
        out.println("</body>");
        out.close();
    }
}
