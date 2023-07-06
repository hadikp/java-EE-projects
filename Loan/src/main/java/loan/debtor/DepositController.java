package loan.debtor;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("deposit")
public class DepositController {

    @Inject
    DebtorService debtorService;

    @DELETE
    @Path("{id}")
    public void deleteDeposit(@PathParam("id") Long id){
        debtorService.deleteDeposit(id);
    }
}
