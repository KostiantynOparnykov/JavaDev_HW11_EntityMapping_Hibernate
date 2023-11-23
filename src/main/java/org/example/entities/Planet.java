package org.example.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;


@Entity
@Table(name = "planet")
@Getter
@Setter

public class Planet {

    @Id
    @Column(name = "id")
    @Pattern(regexp = "^[A-Z0-9]+$")
    private String id;

    @Column(name = "name")
    @Size(min = 1, max = 500)
    private String name;

    @OneToMany(mappedBy = "fromPlanet", cascade = CascadeType.ALL)
    private Set<Ticket> ticketsFrom;

    @OneToMany(mappedBy = "toPlanet", cascade = CascadeType.ALL)
    private Set<Ticket> ticketsTo;

    @Override
    public String toString() {
        return "Planet id = " + id +
                ", Name = " + name;
    }
}
