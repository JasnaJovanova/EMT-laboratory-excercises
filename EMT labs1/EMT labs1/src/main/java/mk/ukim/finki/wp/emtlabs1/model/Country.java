package mk.ukim.finki.wp.emtlabs1.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String continent;

    public Country(String name, String continent){
        this.name = name;
        this.continent = continent;
    }

    public Country() {

    }
}

