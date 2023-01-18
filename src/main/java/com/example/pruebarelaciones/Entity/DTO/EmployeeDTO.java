package com.example.pruebarelaciones.Entity.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class EmployeeDTO {
    private Long id;
    private String name;
    private String lastName;
    private String speciality;
    private DepartamentOutDTO departament;
}
