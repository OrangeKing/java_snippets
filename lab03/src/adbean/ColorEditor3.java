
package adbean;

import java.beans.PropertyChangeListener;
import java.awt.Choice;
import java.awt.Component;
import java.awt.Color;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import propertyAdapter.PropertyEditorChangeAdapter;

/** This color editor will display a custom property editor and
 *  allow the user to select a color name from a list.
 */
public class ColorEditor3 extends PropertyEditorChangeAdapter
              implements ItemListener {
  private static String colorNames[] =
    {"white", "lightGray", "gray", "darkGray", 
     "black", "red", "pink", "orange", "yellow",
     "green", "magenta", "cyan", "blue"};

  private   static Color  colors[] =
    {Color.white, Color.lightGray, Color.gray,
     Color.darkGray, Color.black, Color.red, 
     Color.pink, Color.orange, Color.yellow, 
     Color.green, Color.magenta, Color.cyan, Color.blue};

  private int selected=0;

  private Choice myGUI;

  public String getAsText() {
    return colorNames[selected];
  }
  
  public Component getCustomEditor() {
    if (myGUI == null) {
      myGUI = new Choice();
      for(int i = 0; i < colorNames.length; i++)
        myGUI.addItem(colorNames[i]);
      myGUI.addItemListener(this);
    } 
    return myGUI;
  }
  
  public String getJavaInitializationString() {
    return "java.awt.Color."+colorNames[selected];
  }
  
  public Object getValue() {
    return colors[selected];
  }
  
  public void itemStateChanged(ItemEvent e) {
    setAsText((String)e.getItem());
  } 
  
  public void setAsText(String text) throws IllegalArgumentException {
    Object oldValue = getValue();
    for(selected = 0;
       selected < colorNames.length &&
         !colorNames[selected].equals(text);
        selected++);
    if (selected == colorNames.length)
      selected = 0;
    Object newValue = getValue();
    firePropertyChange(oldValue, newValue);
  }
  
  public void setValue(Object value) {
    selected = 0;
    if (value != null)
      for(int i=0; i < colors.length; i++)
        if (value.equals(colors[i])) {
          selected = i;
          break;
        } 
  }
  
  public boolean supportsCustomEditor() {
    return true;
  }  
}