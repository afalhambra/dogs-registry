package org.mycompany.animals.dogs;

import org.junit.jupiter.api.*;
import org.mycompany.animals.dogs.domain.Dog;
import org.mycompany.animals.dogs.domain.DogsBreedEnum;

import javax.xml.bind.JAXBException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.EnumMap;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.*;

class DogRegistryTest {

    static AbstractFactory abstractFactory;
    static Registry dogRegistry;
    static BiConsumer<DogsBreedEnum, Double> breedEnumDoubleBiConsumer = (key, value) -> {
        switch (key){
            case RHODESIAN_RIDGEBACK:
                assertEquals(38.0, value);
                break;
            case BERNESE_MOUNTAIN_DOG:
                assertEquals(55.0, value);
                break;
            case SHIBA_INU:
                assertEquals(12.25, value);
                break;
            case GERMAN_SHEPHERD:
                assertEquals(24.400000000000002, value);
                break;
            case LABRADOR_RETRIEVER:
                assertEquals(33.0, value);
                break;
            case GREYHOUND:
            case SIBERIAN_HUSKY:
                assertEquals(29.0, value);
                break;
            case JAPANESE_SPITZ:
                assertEquals(12.0, value);
                break;
            case BOHEMIAN_WIREHAIRED_POINTING_GRIFFON:
                assertEquals(28.0, value);
                break;
            default:
                fail("Non valid breed has been found");
                break;
        }
        System.out.println("Breed: " + key.value() + ", Average Weight: " + value);
    };

    @BeforeAll
    public static void init() throws JAXBException {
        abstractFactory = FactoryProvider.getFactory(AnimalType.DOG);
        dogRegistry = (Registry) abstractFactory.load("target/classes/dogs.xml");
    }

    @AfterAll
    public static void cleanUp() {
        dogRegistry = null;
    }

    @Test
    void averageWeight() {
        double avgWeight;
        for (DogsBreedEnum breedEnum : DogsBreedEnum.values()){
            avgWeight = dogRegistry.averageWeight(breedEnum);
            breedEnumDoubleBiConsumer.accept(breedEnum, avgWeight);
        }
    }

    @Test
    void averageWeightPerBreed() {
        EnumMap<DogsBreedEnum, Double> enumMap = dogRegistry.averageWeightPerBreed();
        enumMap.forEach(breedEnumDoubleBiConsumer);
    }

    @Test
    void dogsByCondition() {
        Predicate<Dog> predicate = dog -> dog.getWeight()>38 && dog.getName().equals("Rex");
        List<Dog> dogList = dogRegistry.dogsByCondition(predicate);
        assertEquals(1, dogList.size());
        assertEquals("Rex", dogList.get(0).getName());
        System.out.println("List of Dogs with predicate: " + dogList);
    }

    @Test
    void oldestDogAfterDate() {
        LocalDate date = LocalDate.parse("04-02-2005", DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        Dog dog = dogRegistry.oldestDogAfterDate(date);
        assertEquals("Riki", dog.getName());
        assertEquals("05-02-2005", dog.getDateOfBirth());
        assertEquals(38.0, dog.getWeight());
        assertEquals("Rhodesian Ridgeback", dog.getBreed().value());
        System.out.println("Oldest Dog after " + date.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")) +  " is: " + dog);
    }

}