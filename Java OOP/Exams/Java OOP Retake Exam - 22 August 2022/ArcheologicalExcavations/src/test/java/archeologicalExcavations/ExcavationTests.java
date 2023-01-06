package archeologicalExcavations;

import org.junit.Assert;
import org.junit.Test;


public class ExcavationTests {
    @Test
    public void testShouldCreateSuccessfully(){
        Excavation excavation = new Excavation("Tzarevetz", 10);

        String expectedName = "Tzarevetz";
        int expectedCapacity = 10;

        String  actualName = excavation.getName();
        int actualCapacity = excavation.getCapacity();

        Assert.assertEquals(expectedName, actualName);
        Assert.assertEquals(expectedCapacity, actualCapacity);

    }

    @Test(expected = NullPointerException.class)
    public void testConstructorShouldThrowWhenInvalidName(){
        new Excavation(null, 10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorShouldThrowWhenInvalidCapacity(){
        new Excavation("Tzarevetz", -10);
    }

    @Test
    public void testDddArchaeologistShouldAddSuccessfully(){
        Excavation excavation = new Excavation("Tzarevetz", 10);
        Archaeologist archaeologist = new Archaeologist("Gosho", 5.5);
        excavation.addArchaeologist(archaeologist);

        Assert.assertEquals(1, excavation.getCount());
    }
    @Test(expected = IllegalArgumentException.class)
    public void testAddArchaeologistShouldThrowWhenIllegalCapacity(){
        Excavation excavation = new Excavation("Tzarevetz", 0);
        Archaeologist archaeologist = new Archaeologist("Gosho", 5.5);

        excavation.addArchaeologist(archaeologist);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddArchaeologistShouldThrowWhenDuplicateArcheologist(){
        Excavation excavation = new Excavation("Tzarevetz", 10);
        Archaeologist archaeologist = new Archaeologist("Gosho", 5.5);

        excavation.addArchaeologist(archaeologist);
        excavation.addArchaeologist(archaeologist);
    }
    @Test
    public void testRemoveArchaeologistShouldReturnTrueIfFound(){
        Excavation excavation = new Excavation("Tzarevetz", 10);
        Archaeologist archaeologist = new Archaeologist("Gosho", 5.5);
        excavation.addArchaeologist(archaeologist);

        boolean isRemoved = excavation.removeArchaeologist(archaeologist.getName());
        Assert.assertTrue(isRemoved);
        Assert.assertEquals(0, excavation.getCount());


    }

}
