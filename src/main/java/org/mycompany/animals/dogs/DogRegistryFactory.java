package org.mycompany.animals.dogs;

import org.mycompany.animals.dogs.config.DogRegistryConfig;
import org.mycompany.animals.dogs.domain.Dog;
import org.mycompany.animals.dogs.domain.Dogs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;

public class DogRegistryFactory implements AbstractFactory<Registry> {

    private static final Logger log = LoggerFactory.getLogger(DogRegistryFactory.class);

    @Override
    public Registry load(String fileName) throws JAXBException {

        File xmlFile = new File(fileName);

        JAXBContext jaxbContext;

        jaxbContext = JAXBContext.newInstance(Dogs.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

        Dogs dogs = (Dogs) jaxbUnmarshaller.unmarshal(xmlFile);

        List<Dog> dogList = dogs.getDogs();

        log.debug("Loaded file with " + dogList);

        return new DogRegistry(fileName, dogList);
    }
}
