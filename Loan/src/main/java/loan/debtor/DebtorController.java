package loan.debtor;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
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
}
