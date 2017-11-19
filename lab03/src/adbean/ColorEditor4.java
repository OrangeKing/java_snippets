
package adbean;

import java.beans.PropertyChangeListener;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.Button;
import java.awt.Component;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import propertyAdapter.PropertyEditorChangeAdapter;

/** This color editor will display a custom property editor and
 *  allow the user to select a color name from a list.
 */
public class ColorEditor4 extends PropertyEditorChangeAdapter
              implements ActionListener {
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

  private Panel myGUI;

  public void actionPerformed(ActionEvent e) {
    setAsText(((Button)e.getSource()).getLabel());
  } 
  
  public String getAsText() {
    return colorNames[selected];
  }
  
  public Component getCustomEditor() {
    if (myGUI == null) {
      myGUI = new Panel(new GridLayout(0,2));
      for(int i = 0; i < colorNames.length; i++) {
        Button b = new Button(colorNames[i]);
        b.setBackground(colors[i]);
        b.addActionListener(this);
        myGUI.add(b);
      } 
    } 
    return myGUI;
  }
  
  public String getJavaInitializationString() {
    return "java.awt.Color."+colorNames[selected];
  }
  
  public Object getValue() {
    return colors[selected];
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