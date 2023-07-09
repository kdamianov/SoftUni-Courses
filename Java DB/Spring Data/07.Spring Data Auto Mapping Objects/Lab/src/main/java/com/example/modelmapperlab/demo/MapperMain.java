package com.example.modelmapperlab.demo;

import com.example.modelmapperlab.demo.dto.EmployeeDTO;
import com.example.modelmapperlab.demo.dto.ManagerDto;
import com.example.modelmapperlab.demo.enitites.Address;
import com.example.modelmapperlab.demo.enitites.Employee;
import org.modelmapper.ModelMapper;

import java.math.BigDecimal;
import java.time.LocalDate;

public class MapperMain {
    public static void main(String[] args) {
        ModelMapper mapper = new ModelMapper(); //mapper
        Address address = new Address(
                "streetName",
                10,
                "cityName",
                "countryName");

        Employee manager = new Employee(
                "managerFirstName",
                "managerLastName",
                BigDecimal.TEN,
                LocalDate.now(),
                address,
                true); //source

        Employee employee1 = new Employee(
                "firstName1",
                "lastName1",
                BigDecimal.ONE,
                LocalDate.now(),
                address,
                true);

        Employee employee2 = new Employee(
                "firstName2",
                "lastName2",
                BigDecimal.ZERO,
                LocalDate.now(),
                address,
                true);

        manager.addEmployee(employee1);
        manager.addEmployee(employee2);

        ManagerDto managerDTO = mapper.map(manager, ManagerDto.class);  // -->(Source, Destination)
        EmployeeDTO employee1DTO = mapper.map(employee1, EmployeeDTO.class); // -->(Source, Destination)
        EmployeeDTO employee2DTO = mapper.map(employee1, EmployeeDTO.class); // -->(Source, Destination)

        System.out.println(managerDTO);
    }
}
