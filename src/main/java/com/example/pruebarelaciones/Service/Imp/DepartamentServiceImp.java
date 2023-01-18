package com.example.pruebarelaciones.Service.Imp;

import com.example.pruebarelaciones.Entity.DTO.DepartamentDto;
import com.example.pruebarelaciones.Entity.Departament;
import com.example.pruebarelaciones.Repository.DepartamentRepository;
import com.example.pruebarelaciones.Service.DepartamentService;
import com.example.pruebarelaciones.Utils.Mapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.webjars.NotFoundException;

import java.util.List;

@Service
@AllArgsConstructor
public class DepartamentServiceImp implements DepartamentService {

    private final DepartamentRepository departamentRepository;

    @Override
    @Transactional(readOnly = true)
    public DepartamentDto getById(Long id) {
        return this.toDto(findDepartamentById(id));
    }

    @Override
    @Transactional(readOnly = true)
    public List<DepartamentDto> getAll() {
        return this.departamentRepository.findAll().stream().map(this::toDto).toList();
    }

    @Override
    public DepartamentDto create(DepartamentDto departamentDto) {
        Departament departament = this.toEntity(departamentDto);
        return this.toDto(departamentRepository.save(departament));
    }

    @Override
    @Transactional
    public DepartamentDto update(Long id, DepartamentDto data) {
        Departament departament = findDepartamentById(id);
        departament.setName(data.getName());
        return this.toDto(departamentRepository.save(departament));
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        departamentRepository.delete(this.findDepartamentById(id));
    }

    private Departament findDepartamentById(Long id) {
        return this.departamentRepository.findById(id).orElseThrow(() -> new NotFoundException(String.format(" Record with ID %id not found ", id)));
    }

    private Departament toEntity(DepartamentDto departamentDto) {
        return Mapper.modelMapper().map(departamentDto, Departament.class);
    }

    private DepartamentDto toDto(Departament departament) {
        return Mapper.modelMapper().map(departament, DepartamentDto.class);
    }

}
