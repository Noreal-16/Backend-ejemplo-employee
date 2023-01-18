package com.example.pruebarelaciones.Repository;

import com.example.pruebarelaciones.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
