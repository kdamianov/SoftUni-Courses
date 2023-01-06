package football;


import org.junit.Test;
import static org.junit.Assert.*; //това трябва да се импортне!!!


public class FootballTeamTests {
    private static final String FOOTBALLER_NAME = "Gatzo Batzov";
    private Footballer footballer;

    @Test
    public void testShouldCreateSuccessfully(){
        FootballTeam footballTeam = new FootballTeam("Barcelona", 1);
        int expectedVacantPositions = footballTeam.getVacantPositions();
        String expectedTeamName = footballTeam.getName();

        assertEquals(expectedVacantPositions, 1);
        assertEquals(expectedTeamName, "Barcelona");
    }
    @Test(expected = NullPointerException.class)
    public void testSetNameShouldThrowWhenInvalid(){
        new FootballTeam(null, 1);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testSetVacantPositionsShouldThrowWhenInvalid(){
        new FootballTeam("Barcelona", -1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddFootballerShouldThrowWhenTeamIsFull(){
        FootballTeam footballTeam = new FootballTeam("Barcelona", 1);
        Footballer footballer = new Footballer("Gatzo Batzov");
        footballTeam.addFootballer(footballer);
        footballTeam.addFootballer(new Footballer("Joro Beckhama"));
    }
    @Test
    public void testGetCountShouldReturnCorrectSizeAfterAdding(){
        FootballTeam footballTeam = new FootballTeam("Barcelona", 1);
        Footballer footballer = new Footballer("Gatzo Batzov");
        footballTeam.addFootballer(footballer);

        assertEquals(footballTeam.getCount(), 1);
    }
    @Test
    public void testRemoveFootballerShouldReturnTheCorrectCountAfterRemoving(){
        FootballTeam footballTeam = new FootballTeam("Barcelona", 1);
        Footballer footballer = new Footballer("Gatzo Batzov");
        footballTeam.addFootballer(footballer);
        footballTeam.removeFootballer("Gatzo Batzov");

        assertEquals(0, footballTeam.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveFootballerShouldThrowWhenInavlidPlayerIsRemoved(){
        FootballTeam footballTeam = new FootballTeam("Barcelona", 1);
        footballTeam.removeFootballer("Gatzo Batzov");

    }

    @Test
    public void testFootballerForSaleShouldReturnCorrectObject(){
        FootballTeam footballTeam = new FootballTeam("Barcelona", 1);
        Footballer footballer = new Footballer("Gatzo Batzov");
        footballTeam.addFootballer(footballer);

        footballTeam.footballerForSale("Gatzo Batzov");

        assertFalse(footballer.isActive());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFootballerForSaleShouldThrowWhenInvalid(){
        FootballTeam footballTeam = new FootballTeam("Barcelona", 1);
        footballTeam.footballerForSale("Gatzo Batzov");

    }

    @Test
    public void testGetStatisticsShouldReturnTheCorrectInfo(){
        FootballTeam footballTeam = new FootballTeam("Barcelona", 1);
        Footballer footballer = new Footballer("Gatzo Batzov");
        footballTeam.addFootballer(footballer);

        String expected = "The footballer Gatzo Batzov is in the team Barcelona.";

        assertEquals(footballTeam.getStatistics(), expected);
    }


}
