package calculate.deposit;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("deposit")
@Produces(MediaType.APPLICATION_JSON)
public class DepositController {

    @Inject
    private DepositService depositService;

    @GET
    public List<Deposit> listDeposit(){
        return depositService.listDepositData();
    }
}
