package adbean;

import java.awt.GridLayout;
import java.awt.Graphics;
import java.awt.Rectangle;
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
public class ColorEditor5 extends PropertyEditorChangeAdapter
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
  
  public boolean isPaintable() {
    return true;
  }

  public void paintValue(Graphics gfx, Rectangle box) {
    gfx.setColor(colors[selected]);
    // we use three 3-d rects to over-emphasize the 3-d effect
    // (this way you can be sure this editor is working...)
    gfx.fill3DRect(box.x+2,box.y+2,box.width-5, box.height-5, true);
    gfx.fill3DRect(box.x+3,box.y+3,box.width-7, box.height-7, true);
    gfx.fill3DRect(box.x+4,box.y+4,box.width-9, box.height-9, true);
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