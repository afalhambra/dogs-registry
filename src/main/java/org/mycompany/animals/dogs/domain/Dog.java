//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.3.0 
// Visite <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2019.11.07 a las 09:31:58 AM CET 
//


package org.mycompany.animals.dogs.domain;

import javax.xml.bind.annotation.*;


/**
 * <p>Clase Java para dog complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
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
    protected DogsBreedEnum breed;
    @XmlAttribute(name = "name")
    protected String name;

    /**
     * Obtiene el valor de la propiedad dateOfBirth.
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
     * Define el valor de la propiedad dateOfBirth.
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
     * Obtiene el valor de la propiedad weight.
     *
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Define el valor de la propiedad weight.
     *
     */
    public void setWeight(double value) {
        this.weight = value;
    }

    /**
     * Obtiene el valor de la propiedad breed.
     *
     * @return
     *     possible object is
     *     {@link DogsBreedEnum }
     *
     */
    public DogsBreedEnum getBreed() {
        return breed;
    }

    /**
     * Define el valor de la propiedad breed.
     *
     * @param value
     *     allowed object is
     *     {@link DogsBreedEnum }
     *     
     */
    public void setBreed(DogsBreedEnum value) {
        this.breed = value;
    }

    /**
     * Obtiene el valor de la propiedad name.
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
     * Define el valor de la propiedad name.
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
