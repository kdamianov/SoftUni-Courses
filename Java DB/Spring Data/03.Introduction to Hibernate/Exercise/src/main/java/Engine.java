import entities.Address;
import entities.Employee;
import entities.Project;
import entities.Town;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.sql.SQLOutput;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Comparator;
import java.util.List;


public class Engine implements Runnable {
    private final EntityManager entityManager;
    private BufferedReader bufferedReader;

    public Engine(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void run() {
        System.out.println("Please, select exercise task No:");

        try {
            int taskNum = Integer.parseInt(bufferedReader.readLine());

            switch (taskNum) {
                case 2 -> changeCasing();
                case 3 -> containsEmployee();
                case 4 -> getEmployeesWithSalaryOver50K();
                case 5 -> getEmployeesFromDepartment();
                case 6 -> addNewAddressAndUpdateEmployee();
                case 7 -> getAddressesWithEmployeeCount();
                case 8 -> getEmployeesWithProjects();
                case 9 -> getLatest10Projects();
                case 10 -> increaseSalaries();
                case 11 -> getEmployeesStartingWith();
                case 12 -> getEmployeesMaximumSalaries();
                case 13 -> deleteTown();

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            entityManager.close(); // closing the connection
        }
    }

    private void changeCasing() {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("UPDATE Town t " +
                "SET t.name = UPPER(t.name) " +
                "WHERE LENGTH(t.name) <= 5 ");

        System.out.printf("Affected rows: %d", query.executeUpdate());
        entityManager.getTransaction().commit();
    }

    private void containsEmployee() throws IOException {
        System.out.println("Please, enter employee full name(first name + lastName):");
        String[] fullName = bufferedReader.readLine().split("\\s+");
        String firstName = fullName[0];
        String lastName = fullName[1];

        Long singleResult = entityManager.createQuery("SELECT COUNT(e) FROM Employee e " +
                        "WHERE e.firstName = :f_name AND e.lastName = :l_name", Long.class) // :f_name, etc. --> parameters!
                .setParameter("f_name", firstName)
                .setParameter("l_name", lastName)
                .getSingleResult();

        System.out.printf("Contained: %s", singleResult == 0 ? "No" : "Yes");
    }

    private void getEmployeesWithSalaryOver50K() {
        System.out.println("RESULT:");
        entityManager.createQuery("SELECT e FROM Employee e " +
                        "WHERE e.salary > :min_salary", Employee.class)
                .setParameter("min_salary", BigDecimal.valueOf(50000L)) //the property is set to BigDecimal in the class
                .getResultStream()
                .map(Employee::getFirstName)
                .forEach(System.out::println);
    }

    private void getEmployeesFromDepartment() throws IOException {
        System.out.println("Please select department name:");
        String depName = bufferedReader.readLine();
        System.out.println("RESULT:");
        entityManager
                .createQuery("SELECT e FROM Employee e " +
                        "WHERE e.department.name = :d_name " +
                        "ORDER BY e.salary, e.id", Employee.class)
                .setParameter("d_name", depName)
                .getResultStream()
                .forEach(e -> {
                    System.out.printf("%s %s from %s - $%.2f%n",
                            e.getFirstName(),
                            e.getLastName(),
                            e.getDepartment().getName(),
                            e.getSalary());
                });
    }

    private void addNewAddressAndUpdateEmployee() throws IOException {
        System.out.println("Please, enter employee's last name:");
        String lastName = bufferedReader.readLine();

        Employee employee = entityManager.createQuery("SELECT e from Employee e " +
                        "WHERE e.lastName = :l_name", Employee.class)
                .setParameter("l_name", lastName)
                .getSingleResult();

        Address address = createAddress("Vitoshka 15");

        entityManager.getTransaction().begin(); // set the new address
        employee.setAddress(address);
        entityManager.getTransaction().commit();
    }

    private Address createAddress(String addressInfo) {
        Address address = new Address();
        address.setText(addressInfo);

        entityManager.getTransaction().begin(); //persist the POJO into the DB
        entityManager.persist(address);
        entityManager.getTransaction().commit();

        return address;
    }

    private void getAddressesWithEmployeeCount() {
        System.out.println("ADDRESSES:");
        entityManager
                .createQuery("SELECT a FROM Address a " +
                        "ORDER BY a.employees.size DESC", Address.class)
                .setMaxResults(10)
                .getResultList()
                .forEach(a -> {
                    System.out.printf("%s, %s - %d employees%n",
                            a.getText(),
                            a.getTown() == null
                                    ? "Unknown address"
                                    : a.getTown().getName(),
                            a.getEmployees().size());
                });
    }

    private void getEmployeesWithProjects() throws IOException {
        System.out.println("Please select employee id:");
        int employeeId = Integer.parseInt(bufferedReader.readLine());
        entityManager.createQuery("SELECT e FROM Employee e WHERE e.id = :e_id ", Employee.class)
                .setParameter("e_id", employeeId)
                .getResultList()
                .forEach(e -> {
                    System.out.printf("%s %s - %s%n", e.getFirstName(), e.getLastName(), e.getJobTitle());
                    e.getProjects()
                            .stream()
                            .map(Project::getName)
                            .sorted(String::compareTo)
                            .forEach(p -> System.out.printf("\t  %s%n", p));
                });

    }

    private void getLatest10Projects() {
        System.out.println("RESULT:");
        List<Project> result = entityManager.createQuery("SELECT p FROM Project p " +
                        "ORDER BY p.startDate desc", Project.class)
                .setMaxResults(10)
                .getResultList();

        result.stream()
                .sorted(Comparator.comparing(Project::getName))
                .forEach(p -> System.out.printf("Project name: %s%n" +
                                "\t  Project Description: %s%n" +
                                "\t  Project Start Date:%s%n" +
                                "\t  Project End Date: %s%n",
                        p.getName(),
                        p.getDescription(),
                        p.getStartDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S")),
                        p.getEndDate() == null
                                ? "null"
                                : p.getEndDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S"))));
    }

    private void increaseSalaries() {
        entityManager.getTransaction().begin();
        int affectedRows = entityManager
                .createQuery("UPDATE Employee e " +
                        "SET e.salary = e.salary * 1.12 " +
                        "WHERE e.department.id IN :ids")
                .setParameter("ids", List.of(1, 2, 4, 11))
                .executeUpdate();
        entityManager.getTransaction().commit();
        System.out.printf("Affected rows: %d%n", affectedRows);
        System.out.println("RESULT:");
        entityManager.createQuery("SELECT e FROM Employee e WHERE e.department.id IN :ids", Employee.class)
                .setParameter("ids", List.of(1, 2, 4, 11))
                .getResultList()
                .forEach(e -> System.out.printf("%s %s ($%.2f)%n",
                        e.getFirstName(),
                        e.getLastName(),
                        e.getSalary()));
    }

    private void getEmployeesStartingWith() throws IOException {
        System.out.println("Please, type pattern:");
        String pattern = bufferedReader.readLine();

        entityManager.createQuery("SELECT e FROM Employee e " +
                        "WHERE e.firstName LIKE :pattern", Employee.class)
                .setParameter("pattern", pattern + "%")
                .getResultList()
                .forEach(e -> System.out.printf("%s %s - %s - ($%.2f)%n",
                        e.getFirstName(),
                        e.getLastName(),
                        e.getJobTitle(),
                        e.getSalary()));
    }

    private void getEmployeesMaximumSalaries() {
        List<Object[]> resultList = entityManager.createQuery("SELECT e.department.name, MAX(e.salary) FROM Employee e " +
                        "GROUP BY e.department.id " +
                        "HAVING MAX(e.salary) NOT BETWEEN 30000 AND 70000")
                .getResultList();
        resultList.forEach(r -> System.out.printf("%s %s%n", r[0], r[1]));


    }

    private void deleteTown() throws IOException {
        System.out.println("Please, select town to remove:");
        String town = bufferedReader.readLine();

        Town searchedTown = entityManager.createQuery("SELECT t FROM Town t WHERE t.name = :town", Town.class)
                .setParameter("town", town)
                .getSingleResult();

        deleteEmployeeAddress(town);

        entityManager.getTransaction().begin();

        List<Address> addressList = entityManager.createQuery("SELECT a FROM Address a WHERE a.town.id = :id", Address.class)
                .setParameter("id", searchedTown.getId())
                .getResultList();

        addressList.forEach(entityManager::remove);
        entityManager.remove(searchedTown);

        entityManager.getTransaction().commit();

        if (addressList.size() == 1) {
            System.out.printf("%d address in %s deleted", addressList.size(), town);
        } else {
            System.out.printf("%d addresses in %s deleted", addressList.size(), town);
        }
    }

    private void deleteEmployeeAddress(String town) {
        List<Employee> employees = entityManager.createQuery("SELECT e FROM Employee e " +
                        "WHERE e.address.town.name = :townName", Employee.class)
                .setParameter("townName", town)
                .getResultList();

        entityManager.getTransaction().begin();
        employees.forEach(e -> {
            e.setAddress(null);
            entityManager.persist(e);
        });
        entityManager.getTransaction().commit();
    }
}
