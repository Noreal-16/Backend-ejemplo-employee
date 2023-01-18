package com.example.pruebarelaciones.Service;

import com.example.pruebarelaciones.Entity.DTO.DepartamentDto;
import org.springframework.stereotype.Service;


@Service
public interface DepartamentService extends BaseService<DepartamentDto, Long> {

    DepartamentDto create(DepartamentDto departamentDto);

}
