package cats;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HouseTests {
    private static final String NAME = "CatHouse";
    private static final int CAPACITY = 1;
    private static final String CAT_NAME = "Pisana";
    private House house;
    private Cat cat;


    @Before
    public void setUp() {
        this.house = new House(NAME, CAPACITY);
        this.cat = new Cat(CAT_NAME);
    }

    @Test
    public void testCreateHouseReturnCorrectResult() {
        String expectedName = house.getName();
        house.addCat(cat);

        assertEquals(expectedName, house.getName());
        assertEquals(1, house.getCapacity());
        assertEquals(1, house.getCount());
    }

    @Test(expected = NullPointerException.class)
    public void testSetNameShouldThrowIfInvalid() {
        house = new House(null, 1);
        assertNull(house.getName());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetCapacityShouldThrowIfInvalid() {
        house = new House(NAME, -1);
    }

    @Test
    public void testAddCatShouldReturnCorrectResult() {
        house.addCat(cat);

        assertEquals(1, house.getCount());
    }
    @Test(expected = IllegalArgumentException.class)
    public void testAddCatShouldThrowIfInvalidCapacity(){
        house.addCat(cat);
        house.addCat(new Cat("Matza"));
    }

    @Test
    public void testRemoveCatRemovesSuccessfully(){
        house.addCat(cat);
        house.removeCat(cat.getName());

        assertEquals(0, house.getCount());
    }
    @Test(expected = IllegalArgumentException.class)
    public void testRemoveCatShouldThrowWhenInvalidName(){
        house.addCat(cat);
        house.removeCat(" ");

    }
    @Test
    public void testCatForSaleShouldReturnCorrectAnswer(){
        house.addCat(cat);
        house.catForSale(cat.getName());

        assertFalse(cat.isHungry());
    }
    @Test(expected = IllegalArgumentException.class)
    public void testCatForSaleShouldThrowIfNull(){
        house.addCat(cat);
        house.catForSale(" ");

    }
    @Test
    public void testStatistics(){
        house.addCat(cat);

        String statistics = "The cat Pisana is in the house CatHouse!";

        assertEquals(statistics, house.statistics());
    }


}