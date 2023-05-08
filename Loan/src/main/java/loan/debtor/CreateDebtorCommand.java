package loan.debtor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateDebtorCommand {

    private String name;
    private String city;
    private String street;
    private int houseNumber;
    private int floor;
    private int door;
}
