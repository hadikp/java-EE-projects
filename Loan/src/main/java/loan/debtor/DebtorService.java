package loan.debtor;

import javax.annotation.Resource;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;
import javax.transaction.Transactional;
import java.util.List;

@Singleton
public class DebtorService {

    @PersistenceContext
    private EntityManager em;

    @Resource
    private DataSource dataSource;

    public List<Debtor> listDebtor() {
        return em.createQuery("Select d from Debtor d", Debtor.class).getResultList();
    }

    public Debtor findDebtorById(Long id) {
        Debtor debtor = em.find(Debtor.class, id);
        if(debtor == null){
            throw new EntityNotFoundException("Can't find Debtor by id: " + id);
        }
        return debtor;
    }

    @Transactional
    public Debtor createDebtor(CreateDebtorCommand command) {
        Debtor debtor = new Debtor(command.getName());
        Address address = new Address(command.getCity(), command.getStreet(), command.getHouseNumber(), command.getFloor(), command.getDoor());
        //debtor.setAddress(address);
        em.persist(debtor);
        return debtor;
    }

    @Transactional
    public void deleteDebtor(Long id) {
        Debtor debtor = em.find(Debtor.class, id);
        em.remove(debtor);
    }

    @Transactional
    public void saveDeposit(Deposit depositsFromRestAssured) {
        em.persist(depositsFromRestAssured);
    }

    @Transactional
    public void deleteDeposit(Long id){
        Deposit deposit = em.find(Deposit.class, id);
        em.remove(deposit);
    }
}
