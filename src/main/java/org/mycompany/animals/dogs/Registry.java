package org.mycompany.animals.dogs;

import org.mycompany.animals.dogs.domain.Dog;

import java.time.LocalDate;
import java.util.EnumMap;
import java.util.List;
import java.util.function.Predicate;

public interface Registry<T extends Enum<T>> {

    double averageWeight(T breed);

    EnumMap<T, Double> averageWeightPerBreed();

    List<Dog> dogsByCondition(Predicate<Dog> predicate);

    Dog oldestDogAfterDate(LocalDate date);
}