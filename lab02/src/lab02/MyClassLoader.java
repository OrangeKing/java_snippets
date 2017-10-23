/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab02;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MyClassLoader extends ClassLoader 
{
    String requestedInterface;

    MyClassLoader(String requestedInterface) 
    {
      this.requestedInterface = requestedInterface;
    }

    private Class getClass(String name) throws ClassNotFoundException 
    {
      byte[] b = null;
      String className;
      try 
      {
          b = loadClassFileData(name);
          File f = new File(name);
          className = f.getName().replaceFirst("[.][^.]+$", "");;
          
          Class c = defineClass(className, b, 0, b.length);
          resolveClass(c);
          return c;
      } 

      catch (IOException e) 
      {
          e.printStackTrace();
          return null;
      }
    }

    private byte[] loadClassFileData(String name) throws IOException 
    {
        Path path = Paths.get(name);
        return Files.readAllBytes(path);
    }

    @Override
    public Class loadClass(String name) throws ClassNotFoundException {
      System.out.println("Loading Class '" + name + "'");
      if (name.startsWith("C:\\")) {
        return getClass(name);
      }
      return super.loadClass(name);
    }
}
