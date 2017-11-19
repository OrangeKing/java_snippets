package propertyAdapter;

import java.beans.PropertyEditor;
import java.beans.PropertyChangeListener;
import java.awt.Rectangle;
import java.awt.Graphics;
import java.awt.Component;

public class PropertyEditorAdapter implements PropertyEditor {
  public String    getAsText()                   {return null;}
  public Component getCustomEditor()             {return null;}
  public String    getJavaInitializationString() {return null;}
  public String[]  getTags()                     {return null;}
  public Object    getValue()                    {return null;}
  public boolean   isPaintable()                 {return false;}
  public boolean   supportsCustomEditor()        {return false;}

  public void paintValue(Graphics gfx, Rectangle box)                       {}
  public void addPropertyChangeListener(PropertyChangeListener listener)    {}
  public void removePropertyChangeListener(PropertyChangeListener listener) {}
  public void setAsText(String text) throws IllegalArgumentException        {}
  public void setValue(Object value)                                        {}
}