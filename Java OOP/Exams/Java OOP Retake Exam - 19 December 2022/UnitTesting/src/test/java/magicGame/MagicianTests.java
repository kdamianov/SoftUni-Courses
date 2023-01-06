package magicGame;

import org.junit.Test;

import static org.junit.Assert.*;

public class MagicianTests {
    @Test
    public void testConstructorCreatesMagicianCorrectly(){
        Magician magician = new Magician("Harry Potter", 50);

        assertEquals("Harry Potter", magician.getUsername());
        assertEquals(50, magician.getHealth());
    }
    @Test(expected = NullPointerException.class)
    public void testSetUserNameShouldThrowWhenInvalidUsername(){
        Magician magician = new Magician(null, 50);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testSetHealthShouldThrowWhenInvalidHealth(){
        Magician magician = new Magician("Harry Potter", -1);
    }
    @Test(expected = UnsupportedOperationException.class)
    public void testGetMagicsShouldReturnUnmodifiableCollection(){
        Magician magician = new Magician("Harry Potter", 50);

        magician.getMagics().clear();
    }
    @Test(expected = IllegalStateException.class)
    public void testTakeDamageShouldThrowWhenHealthLowerThanZero(){
        Magician magician = new Magician("Harry Potter", 0);
        magician.takeDamage(5);
    }
    @Test
    public void testTakeDamageShouldSetHealthToZeroWhenDamageIsGreaterThanHealth(){
        Magician magician = new Magician("Harry Potter", 4);
        magician.takeDamage(5);
        assertEquals(0, magician.getHealth());
    }
    @Test
    public void testTakeDamageShouldReturnCorrectNumber(){
        Magician magician = new Magician("Harry Potter", 4);
        magician.takeDamage(2);
        assertEquals(2, magician.getHealth());
    }
    @Test(expected = NullPointerException.class)
    public void testAddMagicShouldThrowWhenInvalidMagic(){
        Magician magician = new Magician("Harry Potter", 50);
        magician.addMagic(null);
    }
    @Test
    public void testAddMagicShouldAddTheCorrectMagic(){
        Magician magician = new Magician("Harry Potter", 50);
        magician.addMagic(new Magic("Dragon fire", 5));
    }
    @Test
    public void testRemoveMagicShouldRemoveTheCorrectMagic(){
        Magician magician = new Magician("Harry Potter", 50);
        Magic magic = new Magic("Dragon fire", 5);
        magician.addMagic(magic);

        assertTrue(magician.removeMagic(magic));
    }
    @Test
    public void testGetMagicShouldReturnTheCorrectMagic(){
        Magician magician = new Magician("Harry Potter", 50);
        Magic magic1 = new Magic("Dragon fire", 5);
        Magic magic2 = new Magic("Sleeping giant", 4);
        magician.addMagic(magic1);
        magician.addMagic(magic2);

        assertEquals(magic2, magician.getMagic(magic2.getName()));

    }


}
