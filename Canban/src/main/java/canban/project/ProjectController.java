package canban.project;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("project")
@Produces(MediaType.APPLICATION_JSON)
public class ProjectController {

    @Inject
    ProjectService projectService;

    @GET
    public List<Project> listProject(){
        return projectService.listProject();
    }
}
