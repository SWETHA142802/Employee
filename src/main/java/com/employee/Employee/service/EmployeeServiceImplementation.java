package com.employee.Employee.service;

import com.employee.Employee.entity.EmployeeEntity;
import com.employee.Employee.repository.EmployeeRepository;
import com.employee.Employee.dto.EmployeeDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImplementation implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImplementation(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<EmployeeDto> findAllEmployee() {
        List<EmployeeEntity> employees = employeeRepository.findAll();
        return employees.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<EmployeeDto> findById(Long id) {
        Optional<EmployeeEntity> employee = employeeRepository.findById(id);
        return employee.map(this::convertToDto);
    }

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        EmployeeEntity employeeEntity = convertToEntity(employeeDto);
        employeeEntity = employeeRepository.save(employeeEntity);
        return convertToDto(employeeEntity);
    }

    @Override
    public EmployeeDto updateEmployee(EmployeeDto employeeDto) {
        EmployeeEntity employeeEntity = convertToEntity(employeeDto);
        employeeEntity = employeeRepository.save(employeeEntity);
        return convertToDto(employeeEntity);
    }
    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    private EmployeeDto convertToDto(EmployeeEntity employeeEntity) {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setId(employeeEntity.getId());
        employeeDto.setName(employeeEntity.getName());
        employeeDto.setGender(employeeEntity.getGender());
        employeeDto.setEmail_id(employeeEntity.getEmail_id());
        employeeDto.setAge(employeeEntity.getAge());
        return employeeDto;
    }

    private EmployeeEntity convertToEntity(EmployeeDto employeeDto) {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setId(employeeDto.getId());
        employeeEntity.setName(employeeDto.getName());
        employeeEntity.setGender(employeeDto.getGender());
        employeeEntity.setEmail_id(employeeDto.getEmail_id());
        employeeEntity.setAge(employeeDto.getAge());
        return employeeEntity;
    }
    }

