package toyStore;


import jdk.jfr.StackTrace;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.*;

public class ToyStoryTest {
    private ToyStore toyStore;

    @Before
    public void setUp() {
        this.toyStore = new ToyStore();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testGetToyShelfReturnsUnmodifiableCollection() {
        toyStore.getToyShelf().clear();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddToyShouldThrowWhenShelfIsInvalid() throws OperationNotSupportedException {
        Toy toy = new Toy("TestManufacturer", "TestID");
        toyStore.addToy("A", toy);
        toyStore.addToy("A", toy);

    }
    @Test(expected = IllegalArgumentException.class)
    public void testAddToyShouldThrowWhenToyIsNull() throws OperationNotSupportedException {
        toyStore.addToy(null, null);

    }
    @Test(expected = OperationNotSupportedException.class)
    public void testAddToyShouldThrowWhenToyExist() throws OperationNotSupportedException {
        Toy toy = new Toy("TestManufacturer", "TestID");
        toyStore.addToy("A", toy);
        toyStore.addToy("B", toy);

    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveGoodsShouldThrowWhenShelfIsInvalid() throws OperationNotSupportedException {
        toyStore.removeToy("invalid", null);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testRemoveGoodsShouldThrowWhenToyIsNotExisting() throws OperationNotSupportedException {
        Toy toy = new Toy("TestManufacturer", "TestID");
        Toy toy2 = new Toy("TestManufacturer2", "TestID2");
        toyStore.addToy("A", toy);
        toyStore.removeToy("A", toy2);
    }

    @Test
    public void testRemoveToyShouldSetValueToNull() throws OperationNotSupportedException {
        Toy toy = new Toy("TestManufacturer", "TestID");
        toyStore.addToy("A", toy);
        toyStore.removeToy("A", toy);

        assertNull(toyStore.getToyShelf().get("A"));
    }

    @Test
    public void testRemoveGoodShouldReturnCorrectMessage() throws OperationNotSupportedException {
        Toy toy = new Toy("TestManufacturer", "TestID");
        toyStore.addToy("A", toy);
        String expected = "Remove toy:TestID successfully!";
        String actual = toyStore.removeToy("A", toy);

        assertEquals(expected, actual);
    }


}