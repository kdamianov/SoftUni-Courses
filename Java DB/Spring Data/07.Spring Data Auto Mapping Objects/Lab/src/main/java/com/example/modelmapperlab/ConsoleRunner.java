package com.example.modelmapperlab;

import com.example.modelmapperlab.entities.Employee;
import com.example.modelmapperlab.entities.dto.EmployeeDTO;
import com.example.modelmapperlab.services.EmployeeService;
import jakarta.persistence.Column;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Component
public class ConsoleRunner implements CommandLineRunner {

    private EmployeeService employeeService;

    @Autowired
    public ConsoleRunner(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public void run(String... args) throws Exception {

//        TODO: REFACTOR!!!!

//        this.persist();

        this.employeeService.findEmployeesBornBefore(1990)
                .forEach(System.out::println);


        ModelMapper mapper = new ModelMapper();

    }

    private void persist() {
        Employee manager = new Employee(
                "managerFirstName",
                "managerLastName",
                BigDecimal.TEN,
                LocalDate.now(),
                null
        );

        Employee firstEmployee = new Employee(
                "firstName1",
                "lastName1",
                BigDecimal.ONE,
                LocalDate.now(),
                manager);
        this.employeeService.save(firstEmployee);
//        manager = this.employeeService.findOneById(Math.toIntExact(firstEmployee.getManager().getId())).get();

        Employee secondEmployee = new Employee(
                "firstName2",
                "lastName2",
                BigDecimal.ONE,
                LocalDate.now(),
                manager);


//        this.employeeService.save(secondEmployee);
    }
}
