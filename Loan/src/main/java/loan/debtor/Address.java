package loan.debtor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Data
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    private String city;
    private String street;

    @Column(name = "house_number")
    private int houseNumber;
    private int floor;
    private int door;
}
