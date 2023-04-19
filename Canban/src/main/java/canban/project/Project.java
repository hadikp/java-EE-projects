package canban.project;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.ejb.Local;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlAttribute;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "projects")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String status;
    private String description;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "closed_at")
    private LocalDate closedAt;

    @Column(name = "due_date")
    private LocalDate dueDate;

    public Project(String name, String status, String description, LocalDate startDate, LocalDate closedAt, LocalDate dueDate) {
        this.name = name;
        this.status = status;
        this.description = description;
        this.startDate = startDate;
        this.closedAt = closedAt;
        this.dueDate = dueDate;
    }

    @XmlAttribute
    public Long getId() {
        return id;
    }
}
