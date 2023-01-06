package petStore;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class PetStoreTests {
    private static final String SPECIES = "lion";
    private static final int MAX_KG = 250;
    private static final double PRICE = 50.5;
    private PetStore petStore;
    private Animal animal;

    @Before
    public void setUp() {
        this.petStore = new PetStore();
        this.animal = new Animal(SPECIES, MAX_KG, PRICE);

    }

    @Test(expected = UnsupportedOperationException.class)
    public void testGetAnimalsShouldReturnUnmodifiableList() {
        List<Animal> animals = petStore.getAnimals();
        animals.remove(1);
    }

    @Test
    public void testGetCountShouldReturnsZeroWhenEmptyAnd1WhenAddedAnimal() {
        assertEquals(0, petStore.getCount());
        petStore.addAnimal(animal);
        assertEquals(1, petStore.getCount());
    }

    @Test
    public void testFindAllAnimalsWithMaxKilogramsReturnsEmptyListWhenNoAnimals() {
        petStore.addAnimal(animal);
        List<Animal> animals = petStore.findAllAnimalsWithMaxKilograms(MAX_KG + 10);
        assertTrue(animals.isEmpty());
    }

    @Test
    public void testFindAllAnimalsWithMaxKilogramsReturnsOnlyHeavier() {
        petStore.addAnimal(animal);
        petStore.addAnimal(new Animal("test", MAX_KG - 2, PRICE));
        List<Animal> animals = petStore.findAllAnimalsWithMaxKilograms(MAX_KG - 1);
        assertEquals(1, animals.size());
        assertEquals(animal.getSpecie(), animals.get(0).getSpecie());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddAnimalShouldThrowWhenNull(){

        petStore.addAnimal(null);
    }

    @Test
    public void testAddAnimalShouldInceraseCount(){
        petStore.addAnimal(animal);
        assertEquals(1, petStore.getCount());
    }

    @Test
    public void testGetTheMostExpensiveAnimalShouldReturnNullWhenEmpty(){
        Animal mostExpensiveAnimal = petStore.getTheMostExpensiveAnimal();
        assertNull(mostExpensiveAnimal);
    }

    @Test
    public void testGetTheMostExpensiveAnimalShouldMostExpensiveAnimal(){
        petStore.addAnimal(animal);
        petStore.addAnimal(new Animal("test", MAX_KG, PRICE - 1));

        Animal theMostExpensiveAnimal = petStore.getTheMostExpensiveAnimal();

        assertEquals(animal.getPrice(), theMostExpensiveAnimal.getPrice(),0.00);
    }

    @Test
    public void testFindAllAnimalBySpecieShouldReturnEmptyListWhenNull() {
        List<Animal> actual = petStore.findAllAnimalBySpecie(SPECIES);
        assertTrue(actual.isEmpty());
    }


    @Test
    public void testFindAllAnimalBySpecieShouldReturnTheSearchedSpecie(){
        String specie = "tiger";
        petStore.addAnimal(animal);
        petStore.addAnimal(new Animal("tiger", MAX_KG, PRICE));


        List<Animal> actual = petStore.findAllAnimalBySpecie(specie);

        assertEquals(1, actual.size());
        assertEquals(specie, actual.get(0).getSpecie());

    }


}

