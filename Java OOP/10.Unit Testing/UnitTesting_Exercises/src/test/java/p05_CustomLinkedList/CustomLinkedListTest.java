package p05_CustomLinkedList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CustomLinkedListTest {
    CustomLinkedList<String> list = new CustomLinkedList<>();

    @Before
    public void prepare() {
        list = new CustomLinkedList<>();
        list.add("Pesho");
        list.add("Gosho");
        list.add("Tosho");
    }

    @Test
    public void testAddShouldAdd() {
        int previousSize = list.getCount();
        list.add("Andrei");
        int currentSize = list.getCount();

        Assert.assertEquals(list.getCount() - 1, list.indexOf("Andrei"));
        Assert.assertEquals(previousSize + 1, currentSize);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetShouldThrowWithNegativeIndex(){
        list.get(-2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetShouldThrowWithBigIndex(){
        list.get(list.getCount() + 1);
    }

    @Test
    public void testGetShouldGet(){
        Assert.assertEquals("Gosho", list.get(1));
    }

}