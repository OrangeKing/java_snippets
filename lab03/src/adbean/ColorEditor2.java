package adbean;

/** A simple extension to the first color editor 
 *  This one passes the colorNames array as the result of
 *  getTags() so the property sheet will have a list of
 *  colors to select from.
 */
public class ColorEditor2 extends ColorEditor1 {

  public String[] getTags() {
    return colorNames;
  } 
}