package org.example.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Table(name = "planet")
@Data
public class Planet {

    @Id
    @Pattern(regexp = "^[A-Z0-9]+$")
    private String id;

    @Size(min = 1, max = 500)
    private String name;
}
