package com.example.pruebarelaciones.Controller;

import com.example.pruebarelaciones.Entity.DTO.DepartamentDto;
import com.example.pruebarelaciones.Service.BaseService;
import com.example.pruebarelaciones.Service.DepartamentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/departament", produces = MediaType.APPLICATION_JSON_VALUE)
public class DepartamentController implements BaseController<DepartamentDto, Long> {
    private final DepartamentService departamentService;

    @Override
    @GetMapping
    public ResponseEntity<List<DepartamentDto>> getAll() {
        return ResponseEntity.ok(this.departamentService.getAll());
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<DepartamentDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(this.departamentService.getById(id));
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<DepartamentDto> update(@PathVariable Long id, @RequestBody DepartamentDto departamentDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(departamentService.update(id, departamentDto));
    }


    @PostMapping
    public ResponseEntity<DepartamentDto> createDepartaments(@RequestBody DepartamentDto departmentDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(departamentService.create(departmentDto));
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        departamentService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
