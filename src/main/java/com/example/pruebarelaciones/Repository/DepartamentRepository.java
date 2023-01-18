package com.example.pruebarelaciones.Repository;

import com.example.pruebarelaciones.Entity.Departament;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartamentRepository extends JpaRepository<Departament, Long> {
}
