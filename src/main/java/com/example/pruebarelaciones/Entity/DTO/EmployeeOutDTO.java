package com.example.pruebarelaciones.Entity.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Data
public class EmployeeOutDTO {
    private Long id;
    private String name;
    private String lastName;
    private String speciality;
}
