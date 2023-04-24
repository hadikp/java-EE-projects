package canban.squad;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateSquadCommand {

    private String name;
    private String description;
    private LocalDate startDate;
}
