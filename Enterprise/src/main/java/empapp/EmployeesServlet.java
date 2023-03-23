package empapp;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/employees")
public class EmployeesServlet extends HttpServlet {

    @Inject
    private EmployeeBean employeesBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*try (PrintWriter writer = resp.getWriter()) {
            writer.println("Hello Java EE");
        }*/
        req.setAttribute("message", "Hello World!");
        req.getRequestDispatcher("/WEB-INF/jsp/employees.jsp").forward(req, resp);
        /*List<Employee> employees = employeesBean.listEmployees();
        req.setAttribute("employees", employees);
        req.getRequestDispatcher("/WEB-INF/jsp/employees.jsp").forward(req, resp);*/
    }
}
