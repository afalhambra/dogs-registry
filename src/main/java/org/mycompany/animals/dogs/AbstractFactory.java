package org.mycompany.animals.dogs;

import javax.xml.bind.JAXBException;

public interface AbstractFactory<T> {
    T load(String fileName) throws JAXBException;
}