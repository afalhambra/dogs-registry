package org.mycompany.animals.dogs;

import org.mycompany.animals.AnimalFactory;
import org.mycompany.animals.AnimalType;
import org.mycompany.animals.FactoryProvider;
import org.mycompany.animals.dogs.domain.Dog;
import org.mycompany.animals.dogs.domain.DogBreed;

import javax.xml.bind.JAXBException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.function.Predicate;

public class AbstractPatternDriver {
    public static void main(String[] args) throws JAXBException {
        AnimalFactory animalFactory;
        
        //creating dog
        animalFactory = FactoryProvider.getFactory(AnimalType.DOG);
        DogRegistry dogRegistry = (DogRegistry) animalFactory.load("target/classes/dogs.xml");

        System.out.println("Average weight for GreyBound is: " + dogRegistry.averageWeight(DogBreed.GREYHOUND));

        System.out.println("Average weight for " + DogBreed.LABRADOR_RETRIEVER.value() + " is: " + dogRegistry.averageWeight(DogBreed.LABRADOR_RETRIEVER));

        System.out.println("Average weight for " + DogBreed.SHIBA_INU.value() + " is: " + dogRegistry.averageWeight(DogBreed.SHIBA_INU));

        System.out.println("Average weight for all breeds: " + dogRegistry.averageWeightPerBreed());

        Predicate<Dog> predicate = dog -> dog.getWeight()>38;

        System.out.println("List of Dogs with predicate: " + dogRegistry.dogsByCondition(predicate));

        LocalDate date = LocalDate.parse("04-02-2005", DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        System.out.println("Oldest Dog after " + date +  " is: " + dogRegistry.oldestDogAfterDate(date));
    }
}
