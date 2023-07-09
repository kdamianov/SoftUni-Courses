package com.example.modelmapperlab.demo.dto;

import com.example.modelmapperlab.demo.enitites.Employee;

import java.util.Set;
import java.util.stream.Collectors;

public class ManagerDto {
    private String firstName;
    private String lastName;
    private Set<EmployeeDTO> subordinates;

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setSubordinates(Set<EmployeeDTO> subordinates) {
        this.subordinates = subordinates;
    }

    @Override
    public String toString() {
        String employeesString = this.subordinates
                .stream()
                .map(EmployeeDTO::toString)
                .map(string -> "    - " + string)
                .collect(Collectors.joining("\n"));

        return String.format("%s %s | Employees: %d%n%s%n",
                this.firstName,
                this.lastName,
                this.subordinates.size(),
                employeesString
        );
    }
}
