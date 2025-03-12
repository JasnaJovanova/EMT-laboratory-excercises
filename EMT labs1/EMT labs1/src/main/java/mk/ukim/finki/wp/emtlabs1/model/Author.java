package mk.ukim.finki.wp.emtlabs1.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String surname;

    @ManyToOne
    private Country country;

    public Author (String name, String surname, Country country){
        this.name = name;
        this.surname = surname;
        this.country = country;
    }

    public Author() {

    }
}

