package canban.squad;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("squad")
@Produces(MediaType.APPLICATION_JSON)
public class SquadController {

    @Inject
    private SquadService squadService;

    @POST
    @Path("create")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createSquad(CreateSquadCommand command){
        Squad squad = squadService.createSquad(command);
        return Response.status(201).entity(squad).build();
    }
}
