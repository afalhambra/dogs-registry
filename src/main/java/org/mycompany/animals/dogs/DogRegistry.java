package org.mycompany.animals.dogs;

import org.mycompany.animals.dogs.config.DogRegistryConfig;
import org.mycompany.animals.dogs.domain.Dog;
import org.mycompany.animals.dogs.domain.DogBreed;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.Predicate;

import static java.util.stream.Collectors.toList;

public class DogRegistry implements Registry<DogBreed> {

    private static final Logger log = LoggerFactory.getLogger(DogRegistry.class);

    private Map<String, List<Dog>> dogsData = new HashMap<>();

    private DogRegistryConfig config = new DogRegistryConfig();

    DogRegistry(String fileName, List<Dog> dogs) { dogsData.put(fileName, dogs); }

    @Override
    public double averageWeight(DogBreed breed) {
        OptionalDouble optionalDouble = dogsData.values().stream()
                .flatMap(List::stream)
                .filter( dog -> dog.getBreed() == breed )
                .mapToDouble(Dog::getWeight)
                .average();
        return optionalDouble.orElse(0);
    }

    @Override
    public EnumMap<DogBreed, Double> averageWeightPerBreed() {
        EnumMap<DogBreed, Double> enumMap = new EnumMap<>(DogBreed.class);
        for (Dog dog : dogsData.values().iterator().next()){
            enumMap.put(dog.getBreed(), averageWeight(dog.getBreed()));
        }
        return enumMap;
    }

    @Override
    public List<Dog> dogsByCondition(Predicate<Dog> predicate) {
        return dogsData.values().stream()
                .flatMap(List::stream)
                .filter(predicate)
                .collect(toList());
    }

    @Override
    public Dog oldestDogAfterDate(LocalDate date) {
        Optional<Dog> optionalDog = dogsData.values().stream()
                .flatMap(List::stream)
                .filter( dog -> {
                    LocalDate dob = LocalDate.parse(dog.getDateOfBirth(), config.getDateFormat());
                    return dob.isAfter(date);
                })
                .reduce( (dogA, dogB) -> {
                    LocalDate dobA = LocalDate.parse(dogA.getDateOfBirth(), config.getDateFormat());
                    LocalDate dobB = LocalDate.parse(dogB.getDateOfBirth(), config.getDateFormat());
                    return (dobA.isBefore(dobB)) ? dogA : dogB;
                });
        return optionalDog.orElse(null);
    }
}
