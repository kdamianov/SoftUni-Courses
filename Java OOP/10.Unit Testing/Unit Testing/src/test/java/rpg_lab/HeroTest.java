package rpg_lab;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class HeroTest {

    @Before
    public void setUp(){

    }
    @Test
    public void testReturnWhenTargetDiesHeroGetsXP(){
        //mock само като искаме да тестваме клас, без да ползваме dependencies (други класове)
        int xp = 10;

        Target facade = mock(Target.class);
        when(facade.isDead()).thenReturn(true);
        when(facade.giveExperience()).thenReturn(xp);

        Weapon weapon = mock(Weapon.class);

        Hero hero = new Hero("Pesho", weapon);

        hero.attack(facade);

        assertEquals(xp, hero.getExperience());

    }
}