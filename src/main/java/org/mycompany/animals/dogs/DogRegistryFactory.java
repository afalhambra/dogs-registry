package org.mycompany.animals.dogs;

import org.mycompany.animals.dogs.domain.Dog;
import org.mycompany.animals.dogs.domain.Dogs;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;

public class DogRegistryFactory implements AbstractFactory<Registry> {

    @Override
    public Registry load(String fileName) throws JAXBException {

        File xmlFile = new File(fileName);

        JAXBContext jaxbContext;

        jaxbContext = JAXBContext.newInstance(Dogs.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

        Dogs dogs = (Dogs) jaxbUnmarshaller.unmarshal(xmlFile);

        List<Dog> dogList = dogs.getDogs();

        System.out.println(dogList);

        return new DogRegistry(fileName, dogList);
    }
}
