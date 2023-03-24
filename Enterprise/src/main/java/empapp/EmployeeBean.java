package empapp;

import javax.ejb.Singleton;
import java.util.Collections;
import java.util.List;


public class EmployeeBean {

    private List<Employee> employees = Collections.synchronizedList(
            List.of(new Employee("John Doe"),
                    new Employee("Jane Done")));
    public List<Employee> findEmployees() {
        return Collections.unmodifiableList(employees);
    }

}
