package org.example.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

@Entity
@Table(name = "ticket")
@Getter
@Setter

public class Ticket {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "from_planet_id", nullable = false)
    private Planet fromPlanet;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "to_planet_id", nullable = false)
      private Planet toPlanet;

    @Override
    public String toString() {
        return "Ticket id: " + id +
                ", Created: " + DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT).format(createdAt) +
                ", Client name: " + client.getName() +
                " -->>Route details-->> " +
                " from: " + fromPlanet.getName() +
                ", to: " + toPlanet.getName();
    }
}
