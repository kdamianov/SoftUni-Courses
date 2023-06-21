import entities.Address;
import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
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
//                case 8 ->
//                case 9 ->
                case 10 -> increaseSalaries();
//                case 11 ->
//                case 12 ->
//                case 13 ->

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

    private void increaseSalaries() {
        // NOT FINISHED!
        entityManager.getTransaction().begin();
        int affectedRows = entityManager
                .createQuery("UPDATE Employee e " +
                        "SET e.salary = e.salary * 1.12 " +
                        "WHERE e.department.id IN :ids")
                .setParameter("ids", List.of(1, 2, 4, 11))
                .executeUpdate();
        entityManager.getTransaction().commit();
        System.out.printf("Affected rows: %d", affectedRows);
        System.out.println("RESULT:");
    }
}
