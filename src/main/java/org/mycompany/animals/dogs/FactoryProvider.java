package org.mycompany.animals.dogs;

public class FactoryProvider {
    public static AbstractFactory getFactory(AnimalType animalType){
        
        if(AnimalType.DOG == animalType){
            return new DogRegistryFactory();
        } else {
            return null;
        }
    }
}