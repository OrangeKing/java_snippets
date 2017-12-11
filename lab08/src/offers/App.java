/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package offers;

import java.io.File;
import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

/**
 *
 * @author Norbert
 */
public class App extends Application
{
    private static final String XML_ADDRESS = "./src/offers/Offers.xml";

    public static void main(String[] args) throws IOException, JAXBException 
    {
        launch(args);
        //writeXML();
    }

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("window.fxml"));
        primaryStage.setTitle("Offer Editor");
        primaryStage.setScene(new Scene(root, 1080, 600));
        primaryStage.show();
    }
    
    public static void writeXML() throws JAXBException
    {
        Offer off1 = new Offer();
        off1.setId(111);
        off1.setName("The Skiis");
        off1.setManufacturer("Alpine");
        off1.setDescription("Vague description here");
        off1.setPrice(12.5);

        // create JAXB context and instantiate marshaller
        JAXBContext context = JAXBContext.newInstance(Offer.class);
        Marshaller m = context.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        // Write to File
        m.marshal(off1, new File(XML_ADDRESS));

    }
}
