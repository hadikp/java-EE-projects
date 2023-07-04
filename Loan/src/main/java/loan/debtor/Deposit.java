package loan.debtor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Deposit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int fund; //tőke
    private Float interest; //kamat
    @Column(name = "deposit_year")
    private int year; //pénz lekötésének évei
    private int payment; //befizetés
    private String annuity; //életjáradék

    @Column(name = "annuities_year")
    private int annuitiesYear; //pénzgyújtés évei

    @Column(name = "deposit_interest_year")
    private  String depositInterestByYear; //kamatos kamat évente

    @Column(name = "deposit_interest_month")
    private  String depositInterestByMonth;

    public Deposit(int fund, Float interest, int year, int payment, String annuity, int annuitiesYear, String depositInterestByYear, String depositInterestByMonth) {
        this.fund = fund;
        this.interest = interest;
        this.year = year;
        this.payment = payment;
        this.annuity = annuity;
        this.annuitiesYear = annuitiesYear;
        this.depositInterestByYear = depositInterestByYear;
        this.depositInterestByMonth = depositInterestByMonth;
    }
}

