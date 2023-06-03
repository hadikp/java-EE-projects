package calculate.deposit;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Singleton
public class DepositService {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public Deposit createData(int fund, double interest, int depositYear, int payment){
        Deposit deposit = new Deposit(fund, interest, depositYear, payment);
        em.persist(deposit);
        return deposit;
    }
}
