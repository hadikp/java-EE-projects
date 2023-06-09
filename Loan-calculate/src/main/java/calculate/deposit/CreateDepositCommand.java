package calculate.deposit;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateDepositCommand {

    private int fund;
    private double interest;
    private int depositYear;
    private int payment;
}
