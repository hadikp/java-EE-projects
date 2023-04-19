package canban.project;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;
import java.util.List;

@WebService(targetNamespace = "http://hadikp.com/project")
public class ProjectEndpoint {

    @Inject
    private ProjectService projectService;

    @WebMethod
    @WebResult(name = "project")
    public List<Project> listProject(){
        return projectService.listProject();
    }
}
