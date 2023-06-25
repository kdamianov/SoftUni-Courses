import vehicleHierarchy.Bike;
import vehicleHierarchy.Car;
import vehicleHierarchy.Vehicle;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class VehicleHierarchyMain {
    public static void main(String[] args) {
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("relations");
        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();

//        Vehicle bike = new Bike();
//        Vehicle car = new Car();

        entityManager.getTransaction().commit();
    }
}