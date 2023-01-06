package rpg_lab;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*; //с wildcard импортваме всичко от този клас

public class AxeTest {
    private static final int ATTACK = 10;
    private static final int DURABILITY = 100;
    private static final int HEALTH = 100;
    private static final int EXPERIENCE = 10;
    private Axe axe;
    private Axe brokenAxe;
    private Dummy dummy;

    @Before//ще се изпълни преди всички други методи
    //сетваме си инстанциите, за да не повтаряме код
    public void setUp(){
        this.axe = new Axe(ATTACK, DURABILITY);
        this.brokenAxe = new Axe(ATTACK, 0);
        this.dummy = new Dummy(HEALTH,EXPERIENCE);
    }

    @Test
    public void testAttackCausesAxeToLooseDurability() {
        //кръщава се максимално ясно: кой метод тества и какво прави
        axe.attack(dummy);
        //тестваме само функционалности за конретния клас, а не dependencies, например Dummy
        int expected = DURABILITY - 1;

        assertEquals(expected, axe.getDurabilityPoints());
    }
    @Test(expected = IllegalStateException.class)
    //Указваме, че очаква Exception, ако е заложена
    public void testAttackThrowsWhenAxeIsBroken(){
        brokenAxe.attack(dummy);

    }
}
