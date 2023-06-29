import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManager gringottsEntityManager = Persistence
                .createEntityManagerFactory("gringotts")
                .createEntityManager();


    }
}