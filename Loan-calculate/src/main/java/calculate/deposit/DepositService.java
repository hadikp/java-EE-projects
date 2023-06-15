package calculate.deposit;

import javax.ejb.Singleton;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

@Singleton
public class DepositService {

    @PersistenceContext
    private EntityManager em;

    @Inject
    Deposit deposit;

    private List<Deposit> depositsData = new ArrayList<>(List.of(new Deposit(10_000_000, 0.05, 10, 150_000)));
    private List<String> depositInterestByYearResults = new ArrayList<>();
    private List<String> depositInterestByMonthResults = new ArrayList<>();
    private List<String> annuityResults = new ArrayList<>();

    public void addData(int fund, double interest, int depositYear, int payment) {
        depositsData.add(new Deposit(fund, interest, depositYear, payment));
    }

    public List<Deposit> listDepositData() {
        return depositsData;
    }

    public List<String> listDepositInterestByYear(){
        return depositInterestByYearResults;
    }
    public List<String> listDepositInterestByMonth(){
        return depositInterestByMonthResults;
    }
    public List<String> listAnnuity(){
        return annuityResults;
    }

    public void depositInterestByYear(){
       Deposit depositFromList = depositsData.get(listDepositData().size()-1);
       double depositResult = deposit.calculateDepositInterestByYear(depositFromList.getFund(), depositFromList.getInterest(), depositFromList.getDepositYear());
       String depositResultFormat = new DecimalFormat("#,###.#").format(depositResult);
       depositInterestByYearResults.add(depositResultFormat);
       depositFromList.setDepositInterestByYear(depositResultFormat);
    }

    public void depositInterestByMonth(){
        Deposit depositFromList = depositsData.get(listDepositData().size()-1);
        double depositResult = deposit.calculateDepositInterestByMonth(depositFromList.getFund(), depositFromList.getInterest(), depositFromList.getDepositYear());
        String depositResultFormat = new DecimalFormat("#,###.#").format(depositResult);
        depositInterestByMonthResults.add(depositResultFormat);
        depositFromList.setDepositInterestByMonth(depositResultFormat);
    }

    public void getAnnuity(){ //gyűjtőjáradék
        Deposit depositFromList = depositsData.get(listDepositData().size()-1);
        double annuityResult = deposit.calculateAnnuity(depositFromList.getPayment(), depositFromList.getInterest(), depositFromList.getDepositYear());
        String annuityResultFormat = new DecimalFormat("#,###.#").format(annuityResult);
        annuityResults.add(annuityResultFormat);
        depositFromList.setAnnuity(annuityResultFormat);
    }


    /*@Transactional
    public Deposit createData(int depositYear, int fund, double interest, int payment){
        Deposit deposit = new Deposit(depositYear, fund, interest, payment);
        em.persist(deposit);
        return deposit;
    }*/
}
