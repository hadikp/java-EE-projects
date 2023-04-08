package empapp;


import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.sql.DataSource;


@TransactionManagement(value = TransactionManagementType.BEAN)
public class DbMigrator {

    @Resource(lookup = "java:/jdbc/EmployeeDS")
    private DataSource dataSource;

    @PostConstruct
    public void init(){
        /*Flyway flyway = Flyway.configure().dataSource(dataSource).load();
        flyway.migrate();*/
    }
}
