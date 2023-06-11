package calculate.deposit;

import javax.ejb.Singleton;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Singleton
public class DepositService {

    @PersistenceContext
    private EntityManager em;

    @Inject
    Deposit deposit;

    private List<Deposit> depositsData = new ArrayList<>(List.of(new Deposit(10_000_000, 0.05, 10, 150_000)));

    public void addData(int fund, double interest, int depositYear, int payment) {
        depositsData.add(new Deposit(fund, interest, depositYear, payment));
    }

    public List<Deposit> listDepositData() {
        return depositsData;
    }

    public double depositInterestByYear(){
        return deposit.calculateDepositInterestByYear();
    }

    /*@Transactional
    public Deposit createData(int depositYear, int fund, double interest, int payment){
        Deposit deposit = new Deposit(depositYear, fund, interest, payment);
        em.persist(deposit);
        return deposit;
    }*/
}
