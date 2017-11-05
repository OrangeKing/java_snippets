/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab02;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author Norbert
 */
public class Lab02 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        File directory = new File("C:\\Users\\Norbert\\Desktop\\workspace\\lab02_alt\\build\\classes\\lab02\\Parsers");
            for (File f : directory.listFiles())
            {
                System.out.println(f.toString());
            }
    }
    
}
