package org.example.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "client")
@Getter
@Setter

public class Client {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    @Size(min = 3, max = 200)
    private String name;

    @OneToMany(mappedBy = "client", fetch = FetchType.EAGER,cascade = CascadeType.REMOVE)
    private Set<Ticket> tickets;

    @Override
    public String toString() {
        return "Client id = " + id +
                ", Name = " + name;
    }
}
