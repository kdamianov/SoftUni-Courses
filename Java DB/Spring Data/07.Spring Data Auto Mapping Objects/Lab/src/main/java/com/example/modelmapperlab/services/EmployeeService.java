package com.example.modelmapperlab.services;

import com.example.modelmapperlab.entities.Employee;
import com.example.modelmapperlab.entities.dto.EmployeeDTO;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    Optional<Employee> findOneById(int id);

    void save(Employee employee);

    List<EmployeeDTO> findEmployeesBornBefore(int birthYear);
}
