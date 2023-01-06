package shopAndGoods;


import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.*;

public class ShopTest {
    private Shop shop;


    @Before
    public void setUp(){
        this.shop = new Shop();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getShelvesShouldReturnUnmodifiableCollection(){
        shop.getShelves().clear();
    }


    @Test(expected = IllegalArgumentException.class)
    public void testAddGoodsShouldThrowWhenShelfIsInvalid() throws OperationNotSupportedException {
        shop.addGoods("invalid", null);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testAddGoodsShouldThrowWhenShelfExists() throws OperationNotSupportedException {
        Goods goods = new Goods("test_name", "test_code");
        shop.addGoods("Shelves1", goods);
        shop.addGoods("Shelves1", goods);
    }
    @Test(expected = OperationNotSupportedException.class)
    public void testAddGoodsShouldThrowWhenGoodInShelf() throws OperationNotSupportedException {
        Goods goods = new Goods("test_name", "test_code");
        shop.addGoods("Shelves1", goods);
        shop.addGoods("Shelves2", goods);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testRemoveGoodsShouldThrowWhenShelfIsInvalid() throws OperationNotSupportedException {
        shop.removeGoods("invalid", null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveGoodShouldThrowWhenInvalidShelf() throws OperationNotSupportedException {
        Goods goods = new Goods("test_name", "test_code");
        Goods goods2 = new Goods("test_name2", "test_code2");
        shop.addGoods("Shelves1", goods);
        shop.removeGoods("Shelves1", goods2);
    }

    @Test
    public void testRemoveGoodShouldReturnCorrectMessage() throws OperationNotSupportedException {
        Goods goods = new Goods("test_name", "test_code");
        shop.addGoods("Shelves1", goods);
        String expected = "Goods: test_code is removed successfully!";
        String actual = shop.removeGoods("Shelves1", goods);

        assertEquals(expected, actual);
    }
    @Test
    public void testRemoveGoodShouldSetValueToNull() throws OperationNotSupportedException {
        Goods goods = new Goods("test_name", "test_code");
        shop.addGoods("Shelves1", goods);
        shop.removeGoods("Shelves1", goods);

        assertNull(null, shop.getShelves().get("Shelves1"));
    }
}