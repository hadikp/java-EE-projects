package empapp;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;


@WebService
public class EmployeeEndpoint {

    public EmployeeEndpoint() {
    }

    @Inject
    private EmployeeBean employeeBean;

    @WebMethod
    public List<Employee> listEmployee(){
        return employeeBean.findEmployees();
    }
}
