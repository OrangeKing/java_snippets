/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherbean;

import java.awt.Component;
import java.beans.PropertyEditorSupport;

/**
 *
 * @author Norbert
 */
public class BarEditor extends PropertyEditorSupport
{
    public Component getCustomEditor()
    {  
        return new BarEditorPanel(this);
    }

   public boolean supportsCustomEditor()
   {  
      return true;
   }
   public String getJavaInitializationString(){
	return ((Double)getValue()).toString();
   }
     public String getAsText()
   {  
      return null;
   }

}
