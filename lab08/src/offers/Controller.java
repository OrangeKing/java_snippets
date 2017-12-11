/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package offers;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.web.WebView;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

/**
 *
 * @author Norbert
 */
public class Controller  
{
    public Controller() throws JAXBException {};

    
    /**
     *
     * Form field values for xml rows
     */
    @FXML
    public TextField idField;
    
    @FXML
    public TextField nameField;
    
    @FXML
    public TextField manufacturerField;
    
    @FXML
    public TextArea descriptionField;
    
    @FXML
    public TextField priceField;
    

    /**
     *
     * Form field for transformations
     */
    @FXML
    public ComboBox styleBox;
        
    @FXML
    public TextField xmlPath;
    
    @FXML
    public WebView html;
    

    /**
     *
     * JAXB marshaller controls
     */
    private Marshaller jaxbMarshaller = JAXBContext.newInstance(Offer.class).createMarshaller();
    private Unmarshaller jaxbUnmarshaller = JAXBContext.newInstance(Offer.class).createUnmarshaller();
    
   
    public void setValues(Offer offer) throws JAXBException
    {
        offer.setId(Integer.parseInt(idField.getText()));
        offer.setName(nameField.getText());
        offer.setManufacturer(manufacturerField.getText());
        offer.setDescription(descriptionField.getText());
        offer.setPrice(Double.parseDouble(priceField.getText()));
    }
    
    public void createOffer() throws JAXBException 
    {
        Offer offer = new Offer();
        
        setValues(offer);

        File file = new File("./src/data/" + nameField.getText() + ".xml");
        
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        jaxbMarshaller.marshal(offer, file);
        
        System.out.println("XML GENERATION SUCCESSFULL");
    }
    
    
    public void editOffer() throws JAXBException 
    {
        Offer offer = (Offer) jaxbUnmarshaller.unmarshal(new File("./src/offers/" + nameField.getText() + ".xml"));
        setValues(offer);
        System.out.println("XML EDIT SUCCESSFULL");
    }
    
    public void displayOffer() throws JAXBException, IOException 
    {
        List<String> lines = Files.readAllLines(Paths.get("./src/data/" + nameField.getText() + ".xml"), StandardCharsets.UTF_8);
        StringBuilder htmlText = new StringBuilder();
        lines.forEach((line) -> {
            htmlText.append(line);
        });
        html.getEngine().loadContent(htmlText.toString());
    }
    
    public void displayOfferHTML() throws JAXBException, IOException 
    {
        List<String> lines = Files.readAllLines(Paths.get("./src/data/Offer.html"), StandardCharsets.UTF_8);
        StringBuilder htmlText = new StringBuilder();
        lines.forEach((line) -> {
            htmlText.append(line);
        });
        html.getEngine().loadContent(htmlText.toString());
        
        System.out.println(styleBox.getValue());
    }

    
    public void styleOffer() throws TransformerException, FileNotFoundException 
    {
        TransformerFactory tFactory=TransformerFactory.newInstance();
        //Source style = new StreamSource("./src/styles/" + styleBox.getValue().toString() + ".xsl");
        Source style = new StreamSource("./src/styles/" + "Apple" + ".xsl");
        Source offer = new StreamSource("./src/data/" + nameField.getText() + ".xml");

        String outputFileName = "./src/data/Offer.html";
        OutputStream htmlFile = new FileOutputStream(outputFileName);
        
        Transformer transformer = tFactory.newTransformer(style);
        transformer.transform(offer, new StreamResult(htmlFile));
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        
        System.out.println("STYLED HTML FROM XML SUCCESSFULL");
    }
}
