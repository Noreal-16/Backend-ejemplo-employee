package com.example.pruebarelaciones.Entity.DTO;

import com.example.pruebarelaciones.Entity.Employee;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import java.util.List;


@NoArgsConstructor
@Data
public class DepartamentDto {
    private Long id;
    private String name;
    private List<EmployeeOutDTO> employees;

    public DepartamentDto(String name) {
        this.name = name;
    }
}
