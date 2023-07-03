package com.employee.Employee.controller;
import com.employee.Employee.service.EmployeeService;
import com.employee.Employee.dto.EmployeeDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @GetMapping
    public List<EmployeeDto> findAllEmployee(){
        return employeeService.findAllEmployee();
    }
    @GetMapping("/{id}")
    public Optional<EmployeeDto> findEmployeeById(@PathVariable("id") Long id){
        return employeeService.findById(id);
    }
    @PostMapping
    public EmployeeDto saveEmployee(@RequestBody EmployeeDto employeeDto){
        return employeeService.saveEmployee(employeeDto);
    }
    @PutMapping
    public EmployeeDto updateEmployee(@RequestBody EmployeeDto employeeDto){
        return employeeService.updateEmployee(employeeDto);
    }
    @DeleteMapping("/{id}")
    public void deleteEmployeeById(@PathVariable("id") Long id){
        employeeService.deleteEmployee(id);
    }
}
