/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Arrays;
import java.util.Collections;

/**
 *
 * @author Norbert
 */

public class ArrayJNI 
{
   public Double[] a;
   public Double[] b;
   public Boolean order;
    
   // hello.dll (Windows) or libhello.so (Unixes)
   public native Double[] sort01(Double[] a, Boolean order);
   static 
   {
     System.loadLibrary("sort01");
   }

   public native Double[] multi02(Double[] a);
   static
   {
     System.loadLibrary("multi02");
   }

   public native void multi03();
   static
   {
     System.loadLibrary("multi03");
   }

   // Temporary sort helper method
   public void multi04()
   {
      b = new Double[a.length];
      for (int i = 0; i < a.length; i++)
      {
         b[i] = a[i];
      }

      Arrays.sort(b);
      if(!order)
      {
         Collections.reverse(Arrays.asList(b));
      }
   }
 
 
   // Test Driver
   public static void main(String[] args) 
   {
      if (args.length != 3 )
      {
         System.out.println("Wrong no. of parameters!");
         System.exit(0);
      }
      else
      {
         ArrayJNI lab = new ArrayJNI();
         lab.a = new Double[]{ 11.2, 23.1, 33.3, 4.1, 9.8 };
         lab.order = Boolean.valueOf(args[1]);

         System.out.println("Array contents");
         for(Double d : lab.a)
         {
            System.out.print(d + " ");
         }


         switch (Integer.valueOf(args[2])) 
         {
            case 1:  lab.b = lab.multi02(lab.a);
            break;
            case 2:  lab.multi03();
            break;

            default: lab.b = lab.sort01(lab.a, lab.order);
            break;
         }

         System.out.println("\nAfter sort: ");
         for(Double d : lab.b)
         {
            System.out.print(d + " ");
         }
      }
   }
}