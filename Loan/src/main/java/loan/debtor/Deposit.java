package loan.debtor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Deposit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int fund; //tőke
    private double interest; //kamat
    private int year; //pénz lekötésének évei
    private int payment; //befizetés
    private double annuity; //életjáradék
    private String annuitiesYear; //pénzgyújtés évei
    private  String depositInterestByYear; //kamatos kamat évente
    private  String depositInterestByMonth;

    public Deposit(int fund, double interest, int year, int payment, double annuity, String annuitiesYear, String depositInterestByYear, String depositInterestByMonth) {
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

