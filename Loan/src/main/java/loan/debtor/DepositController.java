package loan.debtor;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.util.List;

@Path("deposit")
public class DepositController {

    @Inject
    DebtorService debtorService;

    @GET
    public List<Deposit> listDeposit(){
        return debtorService.listDeposit();
    }

    @DELETE
    @Path("{id}")
    public void deleteDeposit(@PathParam("id") Long id){
        debtorService.deleteDeposit(id);
    }
}
