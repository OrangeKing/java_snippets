/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package addressbean;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyEditorSupport;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Norbert
 */
public class AddressEditorPanel extends JPanel
{
    private JComboBox combo = new JComboBox();
    private JLabel infoLabel = new JLabel("New Title: ");
    private JButton button = new JButton("Confirm");
    /**
     *
     * @param ed
     **/
    public AddressEditorPanel(PropertyEditorSupport ed,String[] tags)
    {  
      editor = ed;
      setComboBox(tags);
      setLayout(new FlowLayout());
      add(infoLabel);
      add(combo);
      
      ActionListener buttonListener = new ActionListener()
         {  
            public void actionPerformed(ActionEvent event)
            {  
               editor.setValue(Double.parseDouble(combo.getSelectedItem().toString()));
               editor.firePropertyChange();
            }
         };
      button.addActionListener(buttonListener);
   }
   private void setComboBox(String[] tags)
   {
       for(String p : tags)
       {
           combo.addItem(p);
       }
   }
   private PropertyEditorSupport editor;
}
