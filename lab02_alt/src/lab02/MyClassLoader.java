/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab02;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.lang.ClassLoader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;
/**
 *
 * @author Norbert
 */
public class MyClassLoader extends ClassLoader {
    
        private Hashtable classes = new Hashtable(); 
    
    public MyClassLoader(ClassLoader parent)
    {
        super(parent);
    }
    @Override
    public Class loadClass(String name) throws ClassNotFoundException
    {
        return null;
    }
    protected Class defineClass(byte[] b)
    {
        
        return null;
    }
    public String[] getParserClasses()
    {
        List<String> result = new ArrayList<>();
        DecodeClass("C:\\Users\\Norbert\\Desktop\\workspace\\lab02_alt\\build\\classes\\lab02\\");
        return null;
    }
public synchronized Class loadClass(String className, boolean resolveIt) 
    throws ClassNotFoundException { 
    Class result; 
    byte classData[]; 
    System.out.println(" >>>>>> Load class : "+className); 
    /* Check our local cache of classes */ 
    result = (Class)classes.get(className); 
    if (result != null) { 
        System.out.println(" >>>>>> returning cached result."); 
        return result; 
   }
/* Check with the primordial class loader */ 
   try { 
       result = super.findSystemClass(className); 
       System.out.println(" >>>>>> returning system class (in CLASSPATH)."); 
       return result; 
       } catch (ClassNotFoundException e) { 
                System.out.println("        >>>>>> Not a system class."); 
       } 
     
    /* Define it (parse the class file) */ 

    if (resolveIt) { 
    resolveClass(result); 
    }
    classes.put(className, result); 
    System.out.println("        >>>>>> Returning newly loaded class."); 
    return result; 
} 

    private void DecodeClass(String path)
    {
        try {
            for (File f : new File(path).listFiles())
            {
            //    System.out.println(f.getFileName().toString());
            String text = new String(Files.readAllBytes(Paths.get(f.getAbsolutePath())), StandardCharsets.UTF_8);
            text = text.substring(2);
            Files.write(Paths.get(path), text.getBytes());
            }
        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        }
    }
}
