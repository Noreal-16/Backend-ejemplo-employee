package com.example.pruebarelaciones.Service;

import com.example.pruebarelaciones.Entity.DTO.EmployeeDTO;
import org.springframework.stereotype.Service;


@Service
public interface EmployeeService extends BaseService<EmployeeDTO, Long> {
    EmployeeDTO createEmployee(Long departamentId, EmployeeDTO employeeDTO);
}
