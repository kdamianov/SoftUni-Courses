import entities.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure();
        SessionFactory sessionFactory =
                cfg.buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Student student1 = new Student("Pesho Shepov", 16);
        Student student2 = new Student("Pesho Peshev", 17);

        session.save(student1);
        session.save(student2);

        session.get(Student.class, 1L);
        System.out.println(student1);

        List<Student> studentList =
                session.createQuery("FROM Student " ,
                        Student.class).list();
        for (Student student : studentList) {
            System.out.printf("ID: %d%n", student.getId());
        }

        session.getTransaction().commit();
        session.close();
    }
}