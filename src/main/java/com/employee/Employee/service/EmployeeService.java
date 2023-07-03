package com.employee.Employee.service;
import com.employee.Employee.dto.EmployeeDto;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    List<EmployeeDto> findAllEmployee();
    Optional<EmployeeDto> findById(Long id);
    EmployeeDto saveEmployee(EmployeeDto employeeDto);
    EmployeeDto updateEmployee(EmployeeDto employeeDto);
    void deleteEmployee(Long id);

}
