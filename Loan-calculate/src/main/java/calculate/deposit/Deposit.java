package calculate.deposit;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Deposit { //bankbetét

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int fund;
    private double interest;
    @Column(name = "deposit_year")
    private int depositYear;
    private int payment;

    private String depositInterestByYear;
    private String depositInterestByMonth;

    public Deposit(int fund, double interest, int depositYear, int payment) {
        this.fund = fund;
        this.interest = interest;
        this.depositYear = depositYear;
        this.payment = payment;
    }

    public double calculateDepositInterestByYear(int fund, double interest, int depositYear){//kamatos kamat évente
        return fund * (Math.pow((1 + interest), depositYear));
    }

    public double calculateDepositInterestByMonth(int fund, double interest, int depositYear){
        return fund * (Math.pow((1 + interest / 12), depositYear * 12));
    }
}
