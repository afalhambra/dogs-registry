//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.3.0 
// Visite <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2019.11.06 a las 08:38:33 PM CET 
//


package org.mycompany.animals.dogs.domain;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para dogsBreedEnum.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="dogsBreedEnum"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="Rhodesian Ridgeback"/&gt;
 *     &lt;enumeration value="Bernese Mountain Dog"/&gt;
 *     &lt;enumeration value="Shiba Inu"/&gt;
 *     &lt;enumeration value="Siberian Husky"/&gt;
 *     &lt;enumeration value="German Shepherd"/&gt;
 *     &lt;enumeration value="Labrador Retriever"/&gt;
 *     &lt;enumeration value="Greyhound"/&gt;
 *     &lt;enumeration value="Japanese Spitz"/&gt;
 *     &lt;enumeration value="Bohemian Wirehaired Pointing Griffon"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "dogsBreedEnum")
@XmlEnum
public enum DogsBreedEnum {

    @XmlEnumValue("Rhodesian Ridgeback")
    RHODESIAN_RIDGEBACK("Rhodesian Ridgeback"),
    @XmlEnumValue("Bernese Mountain Dog")
    BERNESE_MOUNTAIN_DOG("Bernese Mountain Dog"),
    @XmlEnumValue("Shiba Inu")
    SHIBA_INU("Shiba Inu"),
    @XmlEnumValue("Siberian Husky")
    SIBERIAN_HUSKY("Siberian Husky"),
    @XmlEnumValue("German Shepherd")
    GERMAN_SHEPHERD("German Shepherd"),
    @XmlEnumValue("Labrador Retriever")
    LABRADOR_RETRIEVER("Labrador Retriever"),
    @XmlEnumValue("Greyhound")
    GREYHOUND("Greyhound"),
    @XmlEnumValue("Japanese Spitz")
    JAPANESE_SPITZ("Japanese Spitz"),
    @XmlEnumValue("Bohemian Wirehaired Pointing Griffon")
    BOHEMIAN_WIREHAIRED_POINTING_GRIFFON("Bohemian Wirehaired Pointing Griffon");
    private final String value;

    DogsBreedEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static DogsBreedEnum fromValue(String v) {
        for (DogsBreedEnum c: DogsBreedEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

    @Override
    public String toString() {
        return value;
    }

}
