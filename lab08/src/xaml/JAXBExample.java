/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xaml;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

/**
 *
 * @author Norbert
 */

public class JAXBExample 
{
    public static void main(String[] args) 
    {

        Offer customer = new Offer();
        customer.setId(100);
        customer.setName("mkyong");
        customer.setAge(29);

        try {

              File file = new File("D:\\Projects\\workspace\\lab08\\src\\xamll");
              JAXBContext jaxbContext = JAXBContext.newInstance(Offer.class);
              Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

              // output pretty printed
              jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

              jaxbMarshaller.marshal(customer, file);
              jaxbMarshaller.marshal(customer, System.out);

            } catch (JAXBException e) {
              e.printStackTrace();
            }

      }
    }