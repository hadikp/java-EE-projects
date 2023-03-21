package empapp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmployeeRepository {

    private List<String> employees = Collections.synchronizedList(new ArrayList<>());

    public void saveEmployee(String name){
        employees.add(name);
    }

    public List<String> findEmployees(){
        return Collections.unmodifiableList(employees);
    }
}
