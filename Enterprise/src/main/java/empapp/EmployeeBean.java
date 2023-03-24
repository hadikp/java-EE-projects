package empapp;

import javax.ejb.Singleton;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class EmployeeBean {

    private List<Employee> employees = Collections.synchronizedList(
            new ArrayList<>(List.of(new Employee("John Doe"),
                    new Employee("Jane Done"))));
    public List<Employee> findEmployees() {
        return Collections.unmodifiableList(employees);
    }

    public void saveEmployee(String name) {
        employees.add(new Employee(name));
    }
}
