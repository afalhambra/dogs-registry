//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.3.0 
// Visite <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2019.11.07 a las 09:31:58 AM CET 
//


package org.mycompany.animals.dogs.domain;

import javax.xml.bind.annotation.*;


/**
 * <p>Java Class for dog complex type.
 * 
 * <p>Below schema fragment specifies the expected content to be for this class.
 * 
 * <pre>
 * &lt;complexType name="dog"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="dateOfBirth" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="weight" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="breed" type="{}dogsBreedEnum"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dog", propOrder = {
    "dateOfBirth",
    "weight",
    "breed"
})
public class Dog {

    @XmlElement(required = true)
    protected String dateOfBirth;
    protected double weight;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected DogBreed breed;
    @XmlAttribute(name = "name")
    protected String name;

    /**
     * Gets the dateOfBirth property value.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Defines dateOfBirth property value.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setDateOfBirth(String value) {
        this.dateOfBirth = value;
    }

    /**
     * Gets the weight property value.
     *
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Defines weight property value.
     *
     */
    public void setWeight(double value) {
        this.weight = value;
    }

    /**
     * Gets the breed property value.
     *
     * @return
     *     possible object is
     *     {@link DogBreed }
     *
     */
    public DogBreed getBreed() {
        return breed;
    }

    /**
     * Defines breed property value.
     *
     * @param value
     *     allowed object is
     *     {@link DogBreed }
     *     
     */
    public void setBreed(DogBreed value) {
        this.breed = value;
    }

    /**
     * Gets the name property value.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Defines name property value.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    @Override
    public String toString() {
        return "Dog [name=" + name +
                ", dateOfBirth=" + dateOfBirth +
                ", weight=" + weight +
                ", breed="+ breed.value() + "]";
    }

}
