/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package offers;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author Norbert
 */
@XmlRootElement(name = "offer")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = { "id", "name", "manufacturer", "description", "price" })
public class Offer
{
    @XmlElement(required = true)
    @XmlSchemaType(name = "positiveInteger")
    private int id;
    
    @XmlElement(required = true)
    @XmlSchemaType(name = "normalizedString")
    private String name;
    
    @XmlSchemaType(name = "normalizedString")
    private String manufacturer;
        
    @XmlSchemaType(name = "string")
    private String description;

    @XmlSchemaType(name = "double")
    private double price;

    public String getName() 
    {
        return name;
    }

    public void setName(String name) 
    {
        this.name = name;
    }

    public int getId() 
    {
        return id;
    }

    public void setId(int id) 
    {
        this.id = id;
    }

    public String getManufacturer() 
    {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) 
    {
        this.manufacturer = manufacturer;
    }

    public String getDescription() 
    {
        return description;
    }

    public void setDescription(String description) 
    {
        this.description = description;
    }

    public double getPrice() 
    {
        return price;
    }

    public void setPrice(double price) 
    {
        this.price = price;
    }

}
