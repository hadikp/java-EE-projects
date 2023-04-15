package canban.board;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAttribute;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "boards")
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "position_number")
    private int positionNumber;

    public Board(String name, int positionNumber) {
        this.name = name;
        this.positionNumber = positionNumber;
    }

    @XmlAttribute
    public Long getId() {
        return id;
    }
}
