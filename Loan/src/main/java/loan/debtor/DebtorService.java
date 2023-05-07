package loan.debtor;

import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Singleton
public class DebtorService {

    @PersistenceContext
    private EntityManager em;

    public List<Debtor> listDebtor() {
        return em.createQuery("Select d from Debtor d", Debtor.class).getResultList();
    }
}
