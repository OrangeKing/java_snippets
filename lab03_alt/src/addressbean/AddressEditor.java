package addressbean;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Component;
import java.beans.PropertyEditorSupport;

/**
 *
 * @author Norbert
 */
class AddressEditor extends PropertyEditorSupport
{
    public Component getCustomEditor()
    {  
        return new AddressEditorPanel(this,getTags());
    }

   public boolean supportsCustomEditor()
   {  
      return true;
   }
   public String getJavaInitializationString(){
	return ((Boolean)getValue()).booleanValue() ? "true" : "false";
   }
     public String getAsText()
   {  
      int value = ((Integer)getValue()).intValue();
      return options[value];
   }

   public void setAsText(String s)
   {  
      for (int i = 0; i < options.length; i++)
      {  
         if (options[i].equals(s))
         {  
            setValue(new Integer(i));
            return;
         }
      }
   }

   public String[] getTags() { return options; }

   private String[] options = { "TitleA", "TitleB", "TitleC", "TitleD" };    
}
