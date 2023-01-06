package gifts;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.Assert.*;

public class GiftFactoryTests {
    private Gift gift;
    private GiftFactory giftFactory;

    @Before
    public void setUp() {
        this.giftFactory = new GiftFactory();
        this.gift = new Gift("Lopata", 1.5);
    }

    @Test
    public void testGetCountShouldReturnCorrectNumber(){
        giftFactory.createGift(gift);
        assertEquals(1, giftFactory.getCount());
    }
    @Test(expected = NullPointerException.class)
    public void testCreateGiftThrowsWhenNull() {
        giftFactory.createGift(null);

    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateGiftThrowsWhenExist() {
        giftFactory.createGift(gift);
        giftFactory.createGift(gift);

    }
    @Test(expected = NullPointerException.class)
    public void testRemoveGiftThrowsWhenNull() {
        giftFactory.removeGift(null);

    }
    @Test
    public void testRemoveGiftReturnsTrueIfGiftIsRemoved() {
        giftFactory.createGift(gift);
        assertTrue(giftFactory.removeGift("Lopata"));
    }

    @Test
    public void testGetPresentWithLeastMagicReturnsTheCorrectGift(){
        Gift tochilka = new Gift("Tochilka", 5.5);
        Gift tigan = new Gift("Tigan", 4.7);

        giftFactory.createGift(gift);
        giftFactory.createGift(tochilka);
        giftFactory.createGift(tigan);
        Gift actual = giftFactory.getPresentWithLeastMagic();

        assertEquals(gift, actual);
    }
    @Test
    public void testGetPresentReturnsTheCorrectType(){
        Gift tochilka = new Gift("Tochilka", 5.5);
        Gift tigan = new Gift("Tigan", 4.7);
        giftFactory.createGift(gift);
        giftFactory.createGift(tochilka);
        giftFactory.createGift(tigan);
        Gift actual = giftFactory.getPresent("Tigan");

        assertEquals(tigan, actual);
    }
    @Test(expected = UnsupportedOperationException.class)
    public void testGetPresentShouldThrowWhenInvalidOperation(){
        giftFactory.createGift(gift);
        giftFactory.getPresents().add(gift);
    }

}
