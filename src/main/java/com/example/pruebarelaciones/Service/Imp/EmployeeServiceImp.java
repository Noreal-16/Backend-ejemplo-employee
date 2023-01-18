package com.example.pruebarelaciones.Service.Imp;

import com.example.pruebarelaciones.Entity.DTO.EmployeeDTO;
import com.example.pruebarelaciones.Entity.Departament;
import com.example.pruebarelaciones.Entity.Employee;
import com.example.pruebarelaciones.Repository.DepartamentRepository;
import com.example.pruebarelaciones.Repository.EmployeeRepository;
import com.example.pruebarelaciones.Service.EmployeeService;
import com.example.pruebarelaciones.Utils.Mapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.webjars.NotFoundException;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeServiceImp implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final DepartamentRepository departamentRepository;

    @Override
    @Transactional(readOnly = true)
    public EmployeeDTO getById(Long id) {
        return this.toDto(this.getByIdEmployee(id));
    }

    @Override
    @Transactional(readOnly = true)
    public List<EmployeeDTO> getAll() {
        return this.employeeRepository.findAll().stream().map(this::toDto).toList();
    }

    @Override
    @Transactional
    public EmployeeDTO createEmployee(Long departamentId, EmployeeDTO employeeDTO) {
        Employee employee = this.toEntity(employeeDTO);
        Departament departament = this.getDepartamentById(departamentId);
        employee.setDepartament(departament);
        return this.toDto(this.employeeRepository.save(employee));
    }

    @Override
    @Transactional
    public EmployeeDTO update(Long id, EmployeeDTO data) {
        Employee employee = getByIdEmployee(id);
        employee.setName(data.getName());
        employee.setSpeciality(data.getSpeciality());
        employee.setLastName(data.getLastName());
        return this.toDto(this.employeeRepository.save(employee));
    }

    @Override
    public void deleteById(Long id) {
        this.employeeRepository.delete(getByIdEmployee(id));
    }


    private Employee getByIdEmployee(Long id) {
        return this.employeeRepository.findById(id).orElseThrow(() -> new NotFoundException(String.format("Record with ID %d not found", id)));
    }

    private EmployeeDTO toDto(Employee employee) {
        return Mapper.modelMapper().map(employee, EmployeeDTO.class);
    }

    private Employee toEntity(EmployeeDTO employeeDTO) {
        return Mapper.modelMapper().map(employeeDTO, Employee.class);
    }

    private Departament getDepartamentById(Long id) {
        Optional<Departament> departament = this.departamentRepository.findById(id);
        if (departament.isEmpty()) {
            throw new NotFoundException(String.format("Departament with ID %d was not found", id));
        }
        return departament.get();
    }
}
