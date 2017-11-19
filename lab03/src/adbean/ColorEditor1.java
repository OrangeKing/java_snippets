package adbean;

import java.awt.Color;
import propertyAdapter.PropertyEditorAdapter;

/** An overly simple color editor.
 *  This color editor will allow the user to type a color name and validate it.
 */
public class ColorEditor1 extends PropertyEditorAdapter {
  // colorNames is protected so we can more easily use it
  //   in ColorEditor2...
  protected static String colorNames[] =
    {"white", "lightGray", "gray", "darkGray", 
     "black", "red", "pink", "orange", "yellow",
     "green", "magenta", "cyan", "blue"};
  private   static Color  colors[] =
    {Color.white, Color.lightGray, Color.gray,
     Color.darkGray, Color.black, Color.red, 
     Color.pink, Color.orange, Color.yellow, 
     Color.green, Color.magenta, Color.cyan, Color.blue};
  private int selected=0;

  public String getAsText() {
    return colorNames[selected];
  }

  public String getJavaInitializationString() {
    return "java.awt.Color."+colorNames[selected];
  }

  public Object getValue() {
    return colors[selected];
  }

  public void setAsText(String text) throws IllegalArgumentException {
    for(selected = 0;
       selected < colorNames.length &&
         !colorNames[selected].equals(text);
        selected++);
    if (selected == colorNames.length)
      selected = 0;
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
}