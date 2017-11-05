/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherbean;

import java.awt.Color;
import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.beans.SimpleBeanInfo;

/**
 *
 * @author Norbert
 */
public class WeatherBeanBeanInfo extends SimpleBeanInfo {
    
public PropertyDescriptor[] getPropertyDescriptors()
   {  
      try
      {  
//         PropertyDescriptor titleDescriptor = new PropertyDescriptor("weather",WeatherBean.class);
          // titlePositionDescriptor.setPropertyEditorClass(TitlePositionEditor.class);
          
          // WEATHER
          PropertyDescriptor weatherDescriptor = new PropertyDescriptor("weather", WeatherBean.class);
          weatherDescriptor.setPropertyEditorClass(WeatherEditor.class);
          // BAR
          PropertyDescriptor barDescriptor = new PropertyDescriptor("bar", WeatherBean.class);
          barDescriptor.setPropertyEditorClass(BarEditor.class);
          // TEMPERATURE
          PropertyDescriptor temperatureDescriptor = new PropertyDescriptor("temperature", WeatherBean.class);
          temperatureDescriptor.setPropertyEditorClass(TemperatureEditor.class);
          // bg color
          PropertyDescriptor bgColorDescriptor = new PropertyDescriptor("background", WeatherBean.class);
          
         return new PropertyDescriptor[]
         {  
            new PropertyDescriptor("title",WeatherBean.class),weatherDescriptor,barDescriptor,temperatureDescriptor,bgColorDescriptor
         };
      }
      catch(IntrospectionException e)
      {  
         e.printStackTrace();
         return null;
      }
   }
}
