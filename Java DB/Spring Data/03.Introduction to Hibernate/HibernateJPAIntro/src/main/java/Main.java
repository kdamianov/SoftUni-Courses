import entities.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("school-jpa");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Student student = new Student("TeoNew");
        em.persist(student);

        student.setName("Bat Georgi");
        em.persist(student);

        Student found = em.find(Student.class, 1);
        System.out.println(found);
        em.getTransaction().commit();
    }
}
