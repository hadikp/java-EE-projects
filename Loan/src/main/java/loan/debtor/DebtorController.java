package loan.debtor;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("debtor")
@Produces(MediaType.APPLICATION_JSON)
public class DebtorController {

    @Inject
    private DebtorService debtorService;

    @GET
    public List<Debtor> listDebtor(){
        return debtorService.listDebtor();
    }

    @GET
    @Path("{id}")
    public Debtor getDebtor(@PathParam("id") Long id){
        return debtorService.findDebtorById(id);
    }

    @POST
    @Path("create")
    @Consumes(MediaType.APPLICATION_JSON)
    private Response createDebtor(CreateDebtorCommand command){
        Debtor debtor = debtorService.createDebtor(command);
        return Response.status(201).entity(debtor).build();
    }
}
