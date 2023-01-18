package com.example.pruebarelaciones.Entity;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;



@Getter
@Setter
@Entity(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_employee", unique = true, nullable = false)
    private Long id;
    private String name;
    private String lastName;
    private String speciality;

    @ManyToOne
    @JoinColumn(name = "departament_id", nullable = false)
    private Departament departament;
}
