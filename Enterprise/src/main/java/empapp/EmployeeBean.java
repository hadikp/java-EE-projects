package empapp;

import javax.ejb.Singleton;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class EmployeeBean {

       private List<Employee> employees = new ArrayList<>(
                List.of(new Employee("John Doe"),
                        new Employee("Jane Doe")));


    public List<Employee> listEmployees(){
        return Collections.unmodifiableList(employees);
    }
}
