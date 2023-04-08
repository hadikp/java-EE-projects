package empapp;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@Column(name = "emp_name")
    //@NotBlank
    //@Size(min = 3, max = 200)
    private String name;

    //@Min(100_000)
    private int salary;

    private String country;

    public Employee() {}

    public Employee(Long id, String name, String country) {
        this.id = id;
        this.name = name;
        this.country = country;
    }

    public Employee(String name) {
        this.name = name;
    }

    public Employee(String name, String country, int salary) {
        this.name = name;
        this.country = country;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }


}
