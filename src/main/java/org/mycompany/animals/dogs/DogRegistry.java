package org.mycompany.animals.dogs;

import org.mycompany.animals.dogs.domain.Dog;
import org.mycompany.animals.dogs.domain.DogsBreedEnum;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.Predicate;

import static java.util.stream.Collectors.toList;

public class DogRegistry implements Registry<DogsBreedEnum> {

    private static Map<String, List<Dog>> dogsData = new HashMap<>();

    DogRegistry(String fileName, List<Dog> dogs) { dogsData.put(fileName, dogs); }

    @Override
    public double averageWeight(DogsBreedEnum breed) {
        OptionalDouble optionalDouble = dogsData.values().stream()
                .flatMap(List::stream)
                .filter( dog -> dog.getBreed().value().equals(breed.value()))
                .mapToDouble(Dog::getWeight)
                .average();
        return optionalDouble.orElse(0);
    }

    @Override
    public EnumMap<DogsBreedEnum, Double> averageWeightPerBreed() {
        EnumMap<DogsBreedEnum, Double> enumMap = new EnumMap<>(DogsBreedEnum.class);
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
                    LocalDate dob = LocalDate.parse(dog.getDateOfBirth(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
                    return dob.isAfter(date);
                })
                .reduce( (dogA, dogB) -> {
                    LocalDate dobA = LocalDate.parse(dogA.getDateOfBirth(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
                    LocalDate dobB = LocalDate.parse(dogB.getDateOfBirth(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
                    return (dobA.isBefore(dobB)) ? dogA : dogB;
                });
        return optionalDog.orElse(null);
    }
}
