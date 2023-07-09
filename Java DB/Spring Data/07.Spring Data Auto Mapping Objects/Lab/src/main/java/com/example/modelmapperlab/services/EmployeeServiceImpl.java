package com.example.modelmapperlab.services;

import com.example.modelmapperlab.entities.Employee;
import com.example.modelmapperlab.entities.dto.EmployeeDTO;
import com.example.modelmapperlab.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Optional<Employee> findOneById(int id) {
        return this.employeeRepository.findById(id);
    }

    @Override
    public void save(Employee employee) {
        this.employeeRepository.save(employee);
    }

    @Override
    public List<EmployeeDTO> findEmployeesBornBefore(int birthYear) {
        LocalDate beforeYear = LocalDate.of(birthYear, 1, 1);
        return this.employeeRepository.findByBirthdayBeforeOrderBySalaryDesc(beforeYear);
    }
}
