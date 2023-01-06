package cafe;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Cafe {
    private List<Employee> employees;
    private String name;
    private int capacity;

    public Cafe(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.employees = new ArrayList<>();
    }
    public void addEmployee(Employee employee){
        if (employees.size() < capacity) {
            employees.add(employee);
        }
    }
    public boolean removeEmployee(String name){
        return employees.removeIf(e -> e.getName().equals(name));
    }
    public Employee getOldestEmployee(){
        return employees.stream().max(Comparator.comparing(Employee::getAge)).orElse(null);
    }
    public Employee getEmployee(String name){
        return employees.stream().filter(e -> e.getName().equals(name)).findFirst().orElse(null);
    }
    public int getCount(){
        return employees.size();
    }
    public String report(){
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Employees working at Cafe %s:", name)).append(System.lineSeparator());
        for (Employee employee : employees) {
            sb.append(employee).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
