package garage;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GarageTests {
    private Garage garage;
    private Car lada;
    private Car moskvich;
    private Car volga;

    @Before
    public void setUp(){
        this.garage = new Garage();
        this.lada = new Car("Lada", 140, 1000.50);
        this.moskvich = new Car("Moskvich", 120, 900.0);
        this.volga = new Car("Volga", 140, 1350.0);

    }


    @Test(expected = IllegalArgumentException.class)
    public void testAddCarShouldThrowIfNull(){
        garage.addCar(null);
    }
    @Test
    public void testAddCarShouldAddSuccessfully(){
        garage.addCar(lada);
        assertEquals(1, garage.getCars().size());
        assertEquals(1, garage.getCount());
    }
    @Test
    public void testGetTheMostExpensiveCarShouldReturnCorrectCar(){
        garage.addCar(lada);
        garage.addCar(moskvich);
        garage.addCar(volga);
        garage.getTheMostExpensiveCar();
        assertEquals(volga, garage.getTheMostExpensiveCar());
    }

    @Test
    public void testFindAllCarsByBrandShouldReturnCorrectNumberOfCars(){
        garage.addCar(lada);
        garage.addCar(lada);
        garage.addCar(moskvich);
        garage.findAllCarsByBrand("Lada");

        assertEquals(2, garage.findAllCarsByBrand("Lada").size());
    }
    @Test
    public void testFindAllCarsWithMaxSpeedAboveShouldReturnCorrectNumberOfCars(){
        garage.addCar(lada);
        garage.addCar(moskvich);
        garage.addCar(volga);
        garage.findAllCarsWithMaxSpeedAbove(125);

        assertEquals(2, garage.findAllCarsWithMaxSpeedAbove(125).size());
    }

}