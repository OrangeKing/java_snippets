package propertyAdapter;

import propertyAdapter.PropertyEditorAdapter;
import java.beans.PropertyChangeSupport;
import java.beans.PropertyChangeListener;

public class PropertyEditorChangeAdapter extends PropertyEditorAdapter {
  private PropertyChangeSupport propertyChangeSupport =
    new PropertyChangeSupport(this);

  public void addPropertyChangeListener(PropertyChangeListener listener) {
    propertyChangeSupport.addPropertyChangeListener(listener);
  }

  protected void firePropertyChange(Object oldValue, Object newValue) {
    propertyChangeSupport.firePropertyChange(null, oldValue, newValue);
  }

  public void removePropertyChangeListener(PropertyChangeListener listener) {
    propertyChangeSupport.removePropertyChangeListener(listener);
  }
}