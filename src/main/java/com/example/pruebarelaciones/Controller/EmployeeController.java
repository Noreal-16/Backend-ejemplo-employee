package com.example.pruebarelaciones.Controller;

import com.example.pruebarelaciones.Entity.DTO.EmployeeDTO;
import com.example.pruebarelaciones.Entity.Employee;
import com.example.pruebarelaciones.Service.EmployeeService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/employee", produces = MediaType.APPLICATION_JSON_VALUE)
public class EmployeeController implements BaseController<EmployeeDTO, Long> {

    private final EmployeeService employeeService;


    @Override
    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(this.employeeService.getById(id));
    }

    @Override
    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> getAll() {
        return ResponseEntity.ok(employeeService.getAll());
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDTO> update(@PathVariable Long id, @RequestBody EmployeeDTO data) {
        return new ResponseEntity<>(this.employeeService.update(id, data), HttpStatus.CREATED);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(Long id) {
        this.employeeService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
