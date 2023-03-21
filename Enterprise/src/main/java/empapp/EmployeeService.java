package empapp;

import java.util.List;

public class EmployeeService {

    private EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    public void saveEmployee(String name){
        String trimmedName = name.trim();
        repository.saveEmployee(trimmedName);
    }

    public List<String> findEmployees(){
        return repository.findEmployees();
    }
}
