package canban.squad;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("squad")
@Produces(MediaType.APPLICATION_JSON)
public class SquadController {

    @Inject
    private SquadService squadService;

    @Transactional
    @Path("create")
    public Squad createBoard(CreateSquadCommand command)
}
