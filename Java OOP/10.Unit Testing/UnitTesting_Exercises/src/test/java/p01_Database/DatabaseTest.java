package p01_Database;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class DatabaseTest {
    private Database database;
    private Integer[] NUMBERS = {7, 3, 2, 1};

    @Before
    public void prepare() throws OperationNotSupportedException {
        database = new Database(NUMBERS);
    }

    //1.Базата се създава успешно
    @Test
    public void constructorCreatesValidDB() throws OperationNotSupportedException {
        Integer[] dbElements = database.getElements();
        Assert.assertArrayEquals(NUMBERS, dbElements); //Може и с for cycle
    }
    //2. Exception > 16 element
    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorShouldThrowWithMoreThan16Elements() throws OperationNotSupportedException {
        Integer[] bigArray = new Integer[17];
        new Database(bigArray);

    }

    //3. Exception < 1 element
    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorShouldThrowWithNoElements() throws OperationNotSupportedException {
        Integer[] emptyArray = new Integer[0];
        new Database(emptyArray);
    }
    //4. Add
    //Exception
    @Test(expected = OperationNotSupportedException.class)
    public void testAddNullShouldThrow() throws OperationNotSupportedException {
        database.add(null);
    }

    //Доабвяме успешно на края на БД
    @Test
    public void testShouldAddElement() throws OperationNotSupportedException {
        database.add(42);
        Integer[] dbElements = database.getElements();
        Assert.assertEquals(dbElements[dbElements.length - 1], Integer.valueOf(42));
        Assert.assertEquals(NUMBERS.length + 1, dbElements.length);
    }

    //5. Remove
    //Empty DB
    @Test(expected = OperationNotSupportedException.class)
    public void testRemoveShouldThrowWithEmptyDB() throws OperationNotSupportedException {
        for (int i = 0; i < NUMBERS.length; i++) {
            database.remove();
        }
        database.remove(); //-> Exception
    }
    @Test
    public void testRemoveShouldRemove() throws OperationNotSupportedException {
        //size--
        //last element should be different
        Integer[] elementBeforeRemove = database.getElements();
        database.remove();
        Integer[] elementsAfterRemove = database.getElements();
        Assert.assertEquals(elementBeforeRemove.length - 1, elementsAfterRemove.length);

        int previousSecondToLastElement = elementBeforeRemove[elementBeforeRemove.length - 2];
        int currentLastElement = elementsAfterRemove[elementsAfterRemove.length - 1];
        Assert.assertEquals(previousSecondToLastElement, currentLastElement);
    }
}