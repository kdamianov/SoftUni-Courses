package blueOrigin;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SpaceshipTests {
    private Spaceship spaceship;
    private Astronaut astronaut;

    @Before
    public void setUp() {
        this.spaceship = new Spaceship("Sputnik", 2);
        this.astronaut = new Astronaut("Yurii Gagarin", 80);
    }

    @Test
    public void testGetCountReturnsCorrectNumber() {
        spaceship.add(astronaut);
        int actual = spaceship.getCount();

        assertEquals(1, actual);
    }

    @Test
    public void testGetNameShouldReturnCorrectName() {
        String actual = spaceship.getName();

        assertEquals("Sputnik", actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddAstronautShouldThrowWhenCapacityFull() {
        spaceship.add(astronaut);
        spaceship.add(new Astronaut("Valentina Tereshkova", 87));
        spaceship.add(new Astronaut("Nikolay Rukavishnikov", 88));
    }
    @Test(expected = IllegalArgumentException.class)
    public void testAddAstronautShouldThrowWhenAstronautExist() {
        spaceship.add(astronaut);
        spaceship.add(astronaut);
    }
    @Test
    public void testRemoveAstronautShouldRemoveTheCorrectly(){
        spaceship.add(astronaut);

        assertTrue(spaceship.remove(astronaut.getName()));
    }
    @Test(expected = IllegalArgumentException.class)
    public void testSetCapacityShouldThrowWhenLowerToZero(){
        spaceship = new Spaceship("Apollo", -2);
    }
    @Test(expected = NullPointerException.class)
    public void testSetNameShouldThrowWhenInvalidName(){
        spaceship = new Spaceship("", 10);
    }

}
