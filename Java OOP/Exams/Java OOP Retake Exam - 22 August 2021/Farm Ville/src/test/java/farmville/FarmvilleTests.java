package farmville;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class FarmvilleTests {
    @Test
    public void testCreateShouldCreateCorrectly(){
        Farm farm = new Farm("Selo", 5);
        assertEquals("Selo", farm.getName());
        assertEquals(0, farm.getCount());
        assertEquals(5, farm.getCapacity());
    }
    @Test(expected = NullPointerException.class)
    public void testCreateShouldThrowWhenNameNull(){
        Farm farm = new Farm(null, 5);
    }
    @Test(expected = NullPointerException.class)
    public void testCreateShouldThrowWhenNameWhiteSpace(){
        Farm farm = new Farm(" ", 5);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testCreateShouldThrowWhenCapacityInvalid(){
        Farm farm = new Farm("Selo", -1);
    }
    @Test
    public void testAddAnimalAddsAnimalAndReturnsCorrectValue(){
        Farm farm = new Farm("Selo", 2);
        List<Animal> animals = new ArrayList<>();
        Animal goat = new Animal("Goat", 2);
        Animal cow = new Animal("Cow", 5);

        animals.add(goat);
        animals.add(cow);
        farm.add(goat);
        farm.add(cow);

        assertEquals(2, animals.size());
        assertEquals(2, farm.getCount());
    }
    @Test(expected = IllegalArgumentException.class)
    public void testAddAnimalAddsAnimalShouldThrowWhenCapacityIsFull(){
        Farm farm = new Farm("Selo", 2);
        Animal goat = new Animal("Goat", 2);
        Animal cow = new Animal("Cow", 5);
        Animal donkey = new Animal("Donkey", 9);

        farm.add(goat);
        farm.add(cow);
        farm.add(donkey);

    }
    @Test(expected = IllegalArgumentException.class)
    public void testAddAnimalAddsAnimalShouldThrowWhenAnimalExists(){
        Farm farm = new Farm("Selo", 3);

        Animal cow = new Animal("Cow", 5);
        Animal cow2 = new Animal("Cow", 6);


        farm.add(cow);
        farm.add(cow2);
    }
    @Test
    public void testRemoveShouldRemoveAnimalProperly(){
        Farm farm = new Farm("Selo", 3);
        Animal goat = new Animal("Goat", 2);
        Animal cow = new Animal("Cow", 5);
        Animal donkey = new Animal("Donkey", 9);
        farm.add(goat);
        farm.add(cow);
        farm.add(donkey);

        assertTrue(farm.remove("Donkey"));
    }
}
