package canban.project;

import javax.annotation.Resource;
import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;
import java.util.List;

@Singleton
public class ProjectService {

    @PersistenceContext
    private EntityManager em;

    @Resource
    private DataSource dataSource;

    public List<Project> listProject() {
        return em.createQuery("select p from Project p", Project.class).getResultList();
    }
}
