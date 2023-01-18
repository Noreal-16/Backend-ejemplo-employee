package com.example.pruebarelaciones.Entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;
import java.util.List;


@Entity(name = "departament")
@Getter
@Setter
@NoArgsConstructor
public class Departament {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_departament", nullable = false, unique = true)
    private Long id;
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "departament")
    private List<Employee> employees;

    public Departament(Long id) {
        this.id = id;
    }
}
