package empapp;


import javax.annotation.Resource;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;
import javax.transaction.Transactional;
import java.util.List;



public class EmployeeBean {

    public EmployeeBean() {
    }

    @Inject
    private NameTrimmer nameTrimmer;

    @PersistenceContext
    private EntityManager em;

    @Resource(mappedName = "java:/jdbc/EmployeeDS")
    private DataSource dataSource;

    public List<Employee> findEmployees() {
        return em.createQuery("select e from Employee e", Employee.class).getResultList();
    }

    @Transactional
    public void saveEmployee(String name) {
        em.persist(new Employee(name));
    }
}
