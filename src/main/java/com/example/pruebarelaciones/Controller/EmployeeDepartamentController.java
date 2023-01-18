package com.example.pruebarelaciones.Controller;

import com.example.pruebarelaciones.Entity.DTO.EmployeeDTO;
import com.example.pruebarelaciones.Service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/employee")
@RequiredArgsConstructor
public class EmployeeDepartamentController {

    private final EmployeeService employeeService;

    @PostMapping("/{departament-id}/departament")
    public ResponseEntity<EmployeeDTO> create(@PathVariable(name = "departament-id") Long departamentId, @RequestBody EmployeeDTO employeeDTO) {
        return new ResponseEntity<>(this.employeeService.createEmployee(departamentId, employeeDTO), HttpStatus.CREATED);
    }
}
