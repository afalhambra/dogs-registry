package org.mycompany.animals.dogs;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.mycompany.animals.dogs.config.DogRegistryConfig;
import org.mycompany.animals.dogs.domain.Dog;
import org.mycompany.animals.dogs.domain.DogBreed;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.JAXBException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.EnumMap;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.*;

class DogRegistryTest {

    private static final Logger log = LoggerFactory.getLogger(DogRegistry.class);
    final static String dogsFile =  "src/test/resources/dogs.xml";
    static AbstractFactory abstractFactory;
    static Registry dogRegistry;
    static BiConsumer<DogBreed, Double> breedEnumDoubleBiConsumer = (breed, avgWeight) -> {
        switch (breed){
            case RHODESIAN_RIDGEBACK:
                assertEquals(38.0, avgWeight);
                break;
            case BERNESE_MOUNTAIN_DOG:
                assertEquals(55.0, avgWeight);
                break;
            case SHIBA_INU:
                assertEquals(12.25, avgWeight);
                break;
            case GERMAN_SHEPHERD:
                assertEquals(24.400000000000002, avgWeight);
                break;
            case LABRADOR_RETRIEVER:
                assertEquals(33.0, avgWeight);
                break;
            case GREYHOUND:
            case SIBERIAN_HUSKY:
                assertEquals(29.0, avgWeight);
                break;
            case JAPANESE_SPITZ:
                assertEquals(12.0, avgWeight);
                break;
            case BOHEMIAN_WIREHAIRED_POINTING_GRIFFON:
                assertEquals(28.0, avgWeight);
                break;
            default:
                fail("Non valid breed has been found");
                break;
        }
        log.debug("Breed: " + breed.value() + ", Average Weight: " + avgWeight);
    };

    @BeforeAll
    public static void init() throws JAXBException {
        abstractFactory = FactoryProvider.getFactory(AnimalType.DOG);
        dogRegistry = (Registry) abstractFactory.load(dogsFile);
        DogRegistryConfig.setEnableLogging();
    }

    @AfterAll
    public static void cleanUp() {
        dogRegistry = null;
    }

    @ParameterizedTest
    @EnumSource(DogBreed.class)
    void averageWeight(DogBreed breed) {
        double avgWeight;
        avgWeight = dogRegistry.averageWeight(breed);
        breedEnumDoubleBiConsumer.accept(breed, avgWeight);
    }

    @Test
    void averageWeightPerBreed() {
        EnumMap<DogBreed, Double> enumMap = dogRegistry.averageWeightPerBreed();
        enumMap.forEach(breedEnumDoubleBiConsumer);
    }

    @Test
    void dogsByCondition() {
        Predicate<Dog> predicate = dog -> dog.getWeight()>38 && dog.getName().equals("Rex");
        List<Dog> dogList = dogRegistry.dogsByCondition(predicate);
        assertEquals(1, dogList.size());
        assertEquals("Rex", dogList.get(0).getName());
        log.debug("List of Dogs with predicate: " + dogList);
    }

    @Test
    void oldestDogAfterDate() {
        LocalDate date = LocalDate.parse("04-02-2005", DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        Dog dog = dogRegistry.oldestDogAfterDate(date);
        assertEquals("Riki", dog.getName());
        assertEquals("05-02-2005", dog.getDateOfBirth());
        assertEquals(38.0, dog.getWeight());
        assertEquals("Rhodesian Ridgeback", dog.getBreed().value());
        log.debug("Oldest Dog after " + date.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")) +  " is: " + dog);
    }

}